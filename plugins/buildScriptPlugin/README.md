Kako bi implementirao klasu koja implementira plugin interface

Kada se plugin apply-a na projekt, gradle kreira instancu plugin klase i zove Plugin.app;y()

Plugin objekt se stvara za svaki projekt nad kojim je applyan plugin

Plugin moze recivat parametar(zavisno sto na sto zelis apllyat plugin):  
   -  Project - koje se na applya na project objekt
   - Settings - koji se onda applya na setting scripte
   - Gradle - koji se applya na inicijalizacijsku skriptu

