## Opcenito 

Plugini dodaju nove taskove, domain objekte(e.g. source set), convencije(e.g. Kotlin lociran u
src/main/kotlin) i extendira core objekte

Plugin mozes napisati u bilo kojem jeziku ako se na kraju kompalira u JVM bytecode
generalo plugin implementiran s Java/Kotlinom koji su staticki pisani ce bolje performati nego isti plugin implementiran pomocu groovya.



### Tipovi plugina po mjestu definiranja:

#### Build script:  
1. Benefiti:  
   - plugin je automaski kompaliran  
   - plugin je automatki ukljucen u classpath od build scripte bez da trebas nesto napraiviti  
2. Nedostaci:  
   -  Plugin nije vidljiv izvan build scripte u kojoj je definiran  
#### buildSrc project:  
1. Benefiti:  
   - mozes staviti svoj plugin u buildSrc direktorij(e.g. rootProjectDir/buildSrc/src/main/kotlin)  
   - gradle ce automatki preuzeti kompaliranje i testiranje plugina
   - dostupran na classpathu unutar build scripete  
   - plugin je vidljiv svakoj build scripte koja je koristena od tog builda  
#### Standalone project: 
 - separate project for plugin, te taj projekt produca i publisha JAR**  
1. Benefiti:  
   - moze se koristiti u vise buildova i moze se dijeliti s drugima??  

