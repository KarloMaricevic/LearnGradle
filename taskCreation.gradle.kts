// 1.
tasks.register("Hello!")

// 2.
tasks.create(
    /* name = */ "ClosureCall!!",
    /* configureClosure = */ closureOf<Task> {
        println("Hi im task using closure!")
    }
)  // closure je groovy klasa

// 3.
tasks.create(
    /* name = */ "Task with defined java type",
    /* type = */ Copy::class.java,
)

tasks.create(
    /* name = */ "TTask with defined java type",
    /* type = */ Copy::class.java,
)


// 4.
tasks.register(
    "Task with java type and constructor args",
    GreetingTask::class.java,
    "Hello", 5,
)
// 5.
tasks.register(
    "Task with java type and action",
    Copy::class.java,
    Action<Copy> { println("Destination dir of copy function is" + this.inputs) },
)

// 6.
tasks.create(
    mapOf(
        Pair("name", "Task defined by options"),   // must be specified
        Pair(
            "type",
            GreetingTask::class.java
        ),  // tip taska kojeg kreiras (moze biti i costum), e.g. task koji u sebi drzi ant naredbu za pokrenuti
        // Pair("override", true),  // not supported anymore
        Pair("dependsOn", arrayListOf("parentTask")),
        Pair("action", Action<GreetingTask> { println("Destination dir of copy function is" + this.inputs) }),
        Pair(
            "group",
            Copy::class.java
        ), // grupa taska se koristi u reportovima i user interfejsima kako bi grupilali zadatke zajedno
        Pair("description", "This is a task created by map of options"),
        Pair("constructorArgs", arrayListOf("string", 1))
    )
)

// 7.
tasks.create(
    mapOf(
        Pair("name", "Task defined by options and configuration closure"),   // must be specified
        Pair(
            "type",
            GreetingTask::class.java
        ),  // tip taska kojeg kreiras (moze biti i costum), e.g. task koji u sebi drzi ant naredbu za pokrenuti, pokrece se cetvrti
        // Pair("override", true),  // not supported anymore
        Pair("dependsOn", arrayListOf("parentTask")),    // zove se druga
        Pair(
            "action",
            Action<GreetingTask> { println("Destination dir of copy function is" + this.inputs) }), // pokrece se treca
        Pair(
            "group",
            Copy::class.java
        ), // grupa taska se koristi u reportovima i user interfejsima kako bi grupilali zadatke zajedno
        Pair("description", "This is a task created by map of options"),
        Pair("constructorArgs", arrayListOf("string", 1))
    ),
    closureOf<Task> { println("Runed configuration closure") } // zove se prva
)

abstract class GreetingTask @Inject constructor(
    private val message: String,
    private val number: Int
) : DefaultTask() {

    init {
    }

    @TaskAction
    fun greet() {
        println("Runned custom task")
    }
}
