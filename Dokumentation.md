# Gavric - MicroProjekt Reisebüro 

Dies ist die Dokumentation vom Micro Projekt. Sie ist wichtig wenn die Anwendung nicht funktionieren sollte, um die Funktionen darzustellen und zu beschreiben.

### Reisebüro - kurze Beschreibung

Es soll nur einen kleiene Teil eines Reisebüro System darstellen.
Die Entitän werden auf ihre Richtigkeit durch bean validation überprüft.

Es gibt 4 Entitäten:

- Customer
-Ein Kunde und/oder Teilnehmer der bei dem Urlaub/Reise teilnimmt.

- Payment
Eine (Teil)Zahlung zu einem Urlaub. 

- Booking
Der Hauptteil der ERD. Hier wird der konkrete Urlaub angelegt. Die Sachen, wie von wann - bis wann der Urlaub gebucht ist, plus die Teilnehmer und das Angebot das in dem Ort vorliegt.

- Offer
Dies ist das Angebot. Er zeigt die einzelnen Destinationen an, mit der jeweiligen Unterkunft, Verpflegung, etc.

### JSF Seite

Hier werden die relevanten Daten angezeigt.

![](./images/ShowData.png)

Bei der Eingabemaske wird darauf geachtet, dass die Eingaben erforderlich sind.

![](./images/AddBooking.png)

Hier wird der Datensatz gleich hinzugefügt. Beim Datum wird per DatePicker die Eingabe getätigt.
Durch den Reset Button wird die Eingabemaske wieder geleert. Somit ist es wieder frisch für eine neuen Eingabe da.

Es ist noch ein kleiner Test vorhanden, bei so einer größe ist es nicht so wichtig, jedoch zeigt es einen guten und richtigen Programmierstil, welcher bei echten Softwares erforderlich ist.


