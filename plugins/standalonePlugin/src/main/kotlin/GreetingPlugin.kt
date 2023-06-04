import org.gradle.api.Plugin
import org.gradle.api.Project

class GreetingPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.task("hello") { task ->
            task.doLast {
                println("Hello from standalonePlugin")
            }
        }
    }
}
