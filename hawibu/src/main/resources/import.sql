insert into Jahr(id, jahr) values(2017, 2017);
insert into Jahr(id, jahr) values(2018, 2018);
insert into Jahr(id, jahr) values(2019, 2019);

insert into Monat(id, monat, name, jahr_id) values(2001, 1, 'Januar 17', 2017);
insert into Monat(id, monat, name, jahr_id) values(2002, 2, 'Februar 17', 2017);
insert into Monat(id, monat, name, jahr_id) values(2003, 3, 'März 17', 2017);
insert into Monat(id, monat, name, jahr_id) values(2004, 4, 'April 17', 2017);
insert into Monat(id, monat, name, jahr_id) values(2005, 5, 'Mai 17', 2017);
insert into Monat(id, monat, name, jahr_id) values(2006, 6, 'Juni 17', 2017);
insert into Monat(id, monat, name, jahr_id) values(2007, 7, 'Juli 17', 2017);
insert into Monat(id, monat, name, jahr_id) values(2008, 8, 'August 17', 2017);
insert into Monat(id, monat, name, jahr_id) values(2009, 9, 'September 17', 2017);
insert into Monat(id, monat, name, jahr_id) values(2010, 10, 'Oktober 17', 2017);
insert into Monat(id, monat, name, jahr_id) values(2011, 11, 'November 17', 2017);
insert into Monat(id, monat, name, jahr_id) values(2012, 12, 'Dezember 17', 2017);

insert into Monat(id, monat, name, jahr_id) values(3001, 1, 'Januar 18', 2018);
insert into Monat(id, monat, name, jahr_id) values(3002, 2, 'Februar 18', 2018);
insert into Monat(id, monat, name, jahr_id) values(3003, 3, 'März 18', 2018);
insert into Monat(id, monat, name, jahr_id) values(3004, 4, 'April 18', 2018);
insert into Monat(id, monat, name, jahr_id) values(3005, 5, 'Mai 18', 2018);
insert into Monat(id, monat, name, jahr_id) values(3006, 6, 'Juni 18', 2018);
insert into Monat(id, monat, name, jahr_id) values(3007, 7, 'Juli 18', 2018);
insert into Monat(id, monat, name, jahr_id) values(3008, 8, 'August 18', 2018);
insert into Monat(id, monat, name, jahr_id) values(3009, 9, 'September 18', 2018);
insert into Monat(id, monat, name, jahr_id) values(3010, 10, 'Oktober 18', 2018);
insert into Monat(id, monat, name, jahr_id) values(3011, 11, 'November 18', 2018);
insert into Monat(id, monat, name, jahr_id) values(3012, 12, 'Dezember 18', 2018);

insert into Monat(id, monat, name, jahr_id) values(4001, 1, 'Januar 19', 2019);
insert into Monat(id, monat, name, jahr_id) values(4002, 2, 'Februar 19', 2019);
insert into Monat(id, monat, name, jahr_id) values(4003, 3, 'März 19', 2019);
insert into Monat(id, monat, name, jahr_id) values(4004, 4, 'April 19', 2019);
insert into Monat(id, monat, name, jahr_id) values(4005, 5, 'Mai 19', 2019);
insert into Monat(id, monat, name, jahr_id) values(4006, 6, 'Juni 19', 2019);
insert into Monat(id, monat, name, jahr_id) values(4007, 7, 'Juli 19', 2019);
insert into Monat(id, monat, name, jahr_id) values(4008, 8, 'August 19', 2019);
insert into Monat(id, monat, name, jahr_id) values(4009, 9, 'September 19', 2019);
insert into Monat(id, monat, name, jahr_id) values(4010, 10, 'Oktober 19', 2019);
insert into Monat(id, monat, name, jahr_id) values(4011, 11, 'November 19', 2019);
insert into Monat(id, monat, name, jahr_id) values(4012, 12, 'Dezember 19', 2019);

insert into geschaeft(id, name, ort) values(1000, 'Aldi', 'Gröpelingen');
insert into geschaeft(id, name, ort) values(1001, 'Penny', 'Gröpelingen');
insert into geschaeft(id, name, ort) values(1002, 'Rewe', 'Gröpelingen');
insert into geschaeft(id, name, ort) values(2000, 'Aldi', 'Nordenham');
insert into geschaeft(id, name, ort) values(2001, 'E-Center', 'Nordenham');

insert into Kategorie(id, name) values(1000, 'Lebensmittel');
insert into Kategorie(id, name) values(1001, 'Süßkram');
insert into Kategorie(id, name) values(1002, 'Getränke');
insert into Kategorie(id, name) values(1003, 'Spiele');
insert into Kategorie(id, name) values(1004, 'Haushalt');
insert into Kategorie(id, name) values(1005, 'Bad');
insert into Kategorie(id, name) values(1006, 'Sonstiges');

insert into Artikel(id, name, kategorie_id) values(1000, 'Toast', 1000);
insert into Artikel(id, name, kategorie_id) values(1001, 'Käse', 1000);
insert into Artikel(id, name, kategorie_id) values(1002, 'Wurst', 1000);

insert into Artikel(id, name, kategorie_id) values(1010, 'Skittles', 1001);
insert into Artikel(id, name, kategorie_id) values(1011, 'Chips', 1001);


insert into Artikel(id, name, kategorie_id) values(1020, 'Wasser', 1002);
insert into Artikel(id, name, kategorie_id) values(1021, 'Cola', 1002);
insert into Artikel(id, name, kategorie_id) values(1022, 'SchwippSchwapp', 1002);
insert into Artikel(id, name, kategorie_id) values(1023, 'Tee (Beutel)', 1002);

insert into Bon(id, date, monat_id, geschaeft_id) values(1000, '20190101', 4001, 1000);

insert into Bon(id, date, monat_id, geschaeft_id) values(1001, '20190202', 4002, 1000)

insert into Posten(id, artikel_id, bon_id, preis, menge) values(1000, 1000, 1000, 0.89, 1);
insert into Posten(id, artikel_id, bon_id, preis, menge) values(1001, 1001, 1000, 0.99, 1);
insert into Posten(id, artikel_id, bon_id, preis, menge) values(1002, 1023, 1000, 1.29, 2);

insert into Posten(id, artikel_id, bon_id, preis, menge) values(2000, 1000, 1001, 1.89, 2);
insert into Posten(id, artikel_id, bon_id, preis, menge) values(2001, 1010, 1001, 3.99, 1);
insert into Posten(id, artikel_id, bon_id, preis, menge) values(2002, 1021, 1001, 6.29, 2);



