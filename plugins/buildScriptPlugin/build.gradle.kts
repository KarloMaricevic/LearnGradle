class GreetingPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.task("hello") {
            doLast {
                println("Hello from the GreetingPlugin")
            }
        }
    }
}

interface GreetingPluginWithExtension {
    val message: Property<String>
    val greeter: Property<String>
}

abstract class GreetingExtensionPlugin : Plugin<Project> {


    @get:OutputFile
    abstract val destination: RegularFileProperty

    override fun apply(project: Project) {
        // Add the 'greeting' extension object
        val extension = project.extensions.create<GreetingPluginWithExtension>("greeting")
        // default message value
        extension.message.convention("Hello from GreetingPlugin")
        // Add a task that uses configuration from the extension object
        project.task("hello") {
            doLast {
                println("${extension.message.get()} from ${extension.greeter.get()}")
            }
        }
    }
}

apply<GreetingExtensionPlugin>()

// Configure the extension, koriste findByType

the<GreetingPluginWithExtension>().message.set("Hi from Gradle")
the<GreetingPluginWithExtension>().greeter.set("Gradle")

configure<GreetingPluginWithExtension> {
    message.set("Hi")
    greeter.set("Gradle")
}

