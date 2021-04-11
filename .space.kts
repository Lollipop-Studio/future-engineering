/**
* JetBrains Space Automation
* This Kotlin-script file lets you automate build activities
* For more info, see https://www.jetbrains.com/help/space/automation.html
*/

job("Build Jar") {
    container(displayName = "Build Jar", image = "ubuntu") {
    	shellScript {
        	content = """
            	echo Build Start
            	./gradlew build
                echo Build End
            """
        }
    }
}
