plugins {
    kotlin("jvm") version "1.8.21"
}

repositories {
    mavenCentral()
}


/*
 -- build scripta se korisiti kako bi konfigurirali projekt, te svaki gradle projekt
 koresponda softwere komponenetu koji se treba izgraditi(lib ili aplikacija)
 -- svaka build scripta je asocirana s objektom tipa Project, kako se build scripta executa ona
 konfigurira taj objekt
 -- kada gradle execupta ovaj file on zapravo kompailra scriptu u klasu tipa KotlinBuildScript, pa
 zbog toga imas akses njegovim propertyima i metodama
*/

/*
 DEKLARIRANJA VARIJABLA:
  1. deklaliraj lokalne varijable sa val/var keywordom
 */
val immutableLocalVariable: String = ""
var mutableLocalVariable: String = ""
// 2. Deklariraj da se moze koristiti unurtar porjekta
// (dohvacanje od prject, tasks, soruce set objekt) - extra properties
// mozes koristiti by e.g. val springVersion by extra("3.1.0.RELEASE")
// ako se extra koristi u sourceSetovima dobiti ces preoprtyNamed kako si ga vec nazvao u svakom
// sourceSetu samo sto ce vecini vrijednsot bili null
// subprojekti mogu pristupiti extra objektu svog roditelja

project.extra["enhancedObjectScopedVariable"] = ""

// tazlika izmedu akcije i configuracije, konfiguracija se izvodi prije runanja taska a akcija na kraju ( kao doLast {})

// ne mozes definirati kotlin objekte van skripte koje onda mozes koristi u build skripti
// (to ukljucuje sve stvari koji imaju object, class...) https://github.com/gradle/gradle/issues/9279
