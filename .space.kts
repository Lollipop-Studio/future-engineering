/**
* JetBrains Space Automation
* This Kotlin-script file lets you automate build activities
* For more info, see https://www.jetbrains.com/help/space/automation.html
*/

job("Default") {
    container(displayName = "Run gradle build", image = "openjdk:11") {
        /*kotlinScript { api ->
            // here can be your complex logic
            api.gradlew("build")
            api.gradlew("publish")
        }*/
        shellScript {
            location = "./gradlew"
            args("build")
        }
        shellScript {
            location = "./gradlew"
            args("publish")
        }
    }
}
