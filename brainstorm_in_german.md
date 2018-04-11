# App Resourcen

Webadresse: http://diskussion.azurewebsites.net/


# Diskutieren
## Grundidee
Tool zum Ausführlichen Diskutieren eines Problems / Ja/Nein Frage mit
abschließender Abstimmung

## Elemente
Folgende sind mögliche Elemente einer Diskussion:
- Diskussionsthema
- Mögliche Lösungen bzw. Ja/Nein
- Argumente:
  * Begründung
  * Beispiele
- Gegenargumente
- Bewertung von Argumenten (Stärke)
  * Stärke von Gegenargumenten schwächen Argument (wenn passend)
  * Individuelle User Bewertung
- Endgültige Abstimmung
- Zeitbeschränkung
- Darstellung von Argumenten
- User

## Ablauf
1. Erstellen eines Diskussionsthema
    * Listen möglicher Lösungen
2. Öffentlich oder privat mit eingeladenen Mitgliedern
3. Erstellen von Argumenten
    * Angabe der unterstützung welche Lösung
    * Angabe von Begründung und Beispielen
    * Verknüpfen mit anderen Argumenten
        + Gegenargumente markieren
4. Bewerten von Argumenten
5. Abstimmen über die Lösung

Der Ablauf von 2./3./4. findet parallel statt.

# Minimum Viable Product
- Gegen-/ Argumente erstellen
- Persistenz
- Assoziationen mit User-Namen (??? wenn es einfach nachträglich zu implementieren ist, dann kein Teil des MVP. )
  * ip-Adresse

# Mögliche zusätzliche Features
- Thema auswählen/erstellen
- Login System mit zugriffsrechten von Usern
- Thema (und damit hinzufügen von Argumenten) über einen Link teilen
- Voting
  * Gewichtung von Argumenten
  * Fazit
- Verknüpfen von Argumenten (Gutes Gegenargument, Duplikat, ...)
- Zeitbeschränkung
- Detailierte Argumentenansicht
- Rollen (Admin, ...)
- Kommentare
- Weitere Ansichten auf alle Argumente

# Software Stack
- Spring 5
  * Initializer: http://start.spring.io/
  * Dokumentation: https://spring.io/docs/reference
- Thymeleaf 3
  * Tutorials/Übersicht: https://www.thymeleaf.org/documentation.html
  * JavaDoc's: https://www.thymeleaf.org/apidocs/thymeleaf-spring5/3.0.9.RELEASE/
- Html5
  * Tutorial/Dokumentation: https://www.w3schools.com/html/default.asp
- CSS
  * Tutorial/Dokumentation: https://www.w3schools.com/css/default.asp
- Azure
  * Azure for Java developers: https://docs.microsoft.com/en-us/java/azure/
  * Spring on Azure: https://docs.microsoft.com/en-us/java/azure/spring-framework/
  * JavaDoc's: http://azure.github.io/azure-sdk-for-java/

## Tutorials (spezialisiert)
Handling Form Submission: https://spring.io/guides/gs/handling-form-submission/
Azure Toolkit for IntelliJ: https://docs.microsoft.com/en-us/java/azure/intellij/azure-toolkit-for-intellij

