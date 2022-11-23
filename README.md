# Projekt: CoWorking Space

Der Coworking Space ist ein Tool bei welchem man Arbeitsplätze in Büros buchen kann. Das Projekt wurde mit Quarkus entwickelt und enthaltet eine Registrierung, ein Login, eine Möglichkeit eine Buchung zu machen und diese auch wieder zu stornieren. Der Admin hat zudem die Möglichkeit einen User zu Verwalten, Buchungen zu Verwalten, neue Plätze hinzuzufügen und auch neue Räume zu erstellen. 

## Erste Schritte

1. Erstelle eine Kopie (fork) von einem Quarkus Projekt.
1. Stelle sicher, dass Docker installiert ist und läuft.
1. Stelle sicher, dass Visual Studio Code und die Erweiterung Remote Container installiert ist.
1. Klone (clone) das Projekt lokal, um damit arbeiten zu können.
1. Öffne das Projekt mit Visual Studio Code.
1. Öffne das Projekt im Entwicklungscontainer.
1. Starte das Projekt mit dem Kommando `Quarkus: Debug current Quarkus Project`
1. Probiere die Client-Applikation unter http://localhost:8080 aus.
1. Schaue die API auf http://localhost:8080/q/swagger-ui/ an.

## Datenbank

Die Daten werden in einer PostgreSQL-Datenbank gespeichert. In der Entwicklungsumgebung wird diese in der [docker-compose-yml](./.devcontainer/docker-compose.yml) konfiguriert.

### Datenbankadministration

Über http://localhost:5050 ist PgAdmin4 erreichbar. Damit lässt sich die Datenbank komfortabel verwalten. Der Benutzername lautet `zli@example.com` und das Passwort `zli*123`. Die Verbindung zur PostgreSQL-Datenbank muss zuerst mit folgenden Daten konfiguriert werden:
 - Host name/address: `db`
 - Port: `5432`
 - Maintenance database: `postgres`
 - Username: `postgres`
 - Password: `postgres`

## Automatische Tests

Die automatischen Tests können mit `./mvnw quarkus:test` ausgeführt werden. Für die automatischen Tests wird nicht die PostgreSQL-Datenbank verwendet, sondern eine H2-Datenbank, welche sich im Arbeitsspeicher während der Ausführung befindet.

## Projekt starten

Das Projekt kann man über den Command `./mvnw quarkus:dev` gestartet werden.

## Testdaten laden

Die Testdaten werden über das `import.sql` im Ordner `ressources` geladen.

## Testuser / Zugangsdaten

`Admin:`
vorname = Tobias
nachname = Bertschi
geburtsdatum = 2004-11-12
email = gotteron89tb@gmail.com
passwort = tobiasbertschi
isAdmin = true

`Mitglied:`
vorname = Maurin
nachname = Schucan
geburtsdatum = 2004-12-04
email = maurin.schucan@lernende.bbw.ch
passwort = maurinschucan
isAdmin = false

## Sonstiges

Durch ein Missverständniss mit Herr Bosshard habe ich im Fachklassendiagramm eine Klassen nicht erstellt. (Raum)
Andere Klassen musste ich ebenfalls noch zusätzlich erstellen, da ich bei der Planung noch nicht realisiert habe, dass man diese benötigt.

Statt der Kommentarfunktion habe ich nun eine Raumverwaltung & eine Platzverwaltung gemacht die vom Admin verwaltet werden kann, da die Kommentarfunktion etwas zu zeitaufwändig war und ich die Idee für die Platz- und Raumverwaltung bei der Planung noch nicht hatte.

Für diese neuen Funktionen und das Login musste ich dann auch noch Endpoints erstellen, welche ich bei den Schnittstellen vergessen habe aufzuführen.

## Github

Hier ist noch der Link zu meinem GitHub:
- https://github.com/tobiasbertschi/Modul223