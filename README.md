# Readme for PG3100 Innlevering 2 #

* Dette repository er til innlevering 2 i faget PG3100 Avansert Javaprogrammering 1.

### Programmet krever ###

* DBHandlerBokliste plassert i pakke med navn «innlevering2», eller endre package navn i koden. 
* Hjelperklassen ConnectToDB må være importert i DBHandlerBokliste. 
* JAR mysql-connector-java er importert i prosjektmappen.
* En MYSQL database tilkobling må være tilgjengelig på localhost. 
* En database må være opprettet ved navn pg3100. 
    * Alternativt kan du endre server og databasenavn i konstruktøren til programmet. 
* Databasen må ha tabellen 'bokliste'
    * Jeg har inkludert et sql skript for å enkelt opprette tabellen bokliste med rader av opplysninger. Denne kan importeres fra phpmyadmin.
    * Tabellen bokliste med noen rader opplysninger (eksempler) kan også opprettes ved å kjøre programmet CreateTableBokliste.