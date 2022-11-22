INSERT INTO "User" (
    vorname, nachname, geburtsdatum, email, passwort, isadmin) VALUES (
    'Tobias', 'Bertschi', '2004-11-12', 'gotteron89tb@gmail.com', 'tobiasbertschi', true
    );

INSERT INTO "User" (
    vorname, nachname, geburtsdatum, email, passwort, isadmin) VALUES (
        'Maurin', 'Schucan', '2004-12-04', 'maurin.schucan@lernende.bbw.ch', 'maurinschucan', false
    );

INSERT INTO "Raum" (
    einzel ) VALUES (
        true
    );

INSERT INTO "Raum" (
    einzel ) VALUES (
        false
    );

INSERT INTO "Buchung" (
    status, datum, ganztag, notiz, user_id, raum_id ) VALUES (
        'angefragt', '2022-11-25', true, '', 1, 2);

INSERT INTO "Buchung" (
    status, datum, ganztag, notiz, user_id, raum_id ) VALUES (
        'bestaetigt', '2022-11-26', false, '', 1, 1
    );

INSERT INTO "Buchung" (
    status, datum, ganztag, notiz, user_id, raum_id ) VALUES (
        'abgelehnt', '2022-11-25', true, 'Platz wird für private Zwecke genutzt.', 2, 2
    );

INSERT INTO "Platz" (
    stehpult, raum_id ) VALUES (
        true, 1
    );

INSERT INTO "Platz" (
    stehpult, raum_id ) VALUES (
        false, 2
    );

INSERT INTO "Platz" (
    stehpult, raum_id ) VALUES (
        true, 2
    );