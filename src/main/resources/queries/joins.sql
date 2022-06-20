--Right
SELECT * FROM clients RIGHT JOIN cards ON idClients=1;
SELECT * FROM accounts RIGHT JOIN discounts on idAccounts =3;
SELECT * FROM credits RIGHT JOIN debts on idCredits =4;
SELECT c.first_name,c.last_name,a.idAccounts FROM Accounts a RIGHT JOIN Clients c ON c.idClients=a.idAccounts;
SELECT c.first_name,c.last_name,a.idAccounts FROM Accounts a RIGHT JOIN Clients c ON c.idClients>a.idAccounts;

--Left
SELECT * FROM accounts LEFT JOIN cards ON idAccounts=1;
SELECT * FROM employees LEFT JOIN phones ON idEmployees=2;
SELECT * FROM Cards LEFT JOIN Accounts ON idCards=2;
SELECT c.first_name,c.email,a.idAppointments FROM Appointments a LEFT JOIN Clients c ON c.idClients=a.idAppointments;
SELECT c.first_name,c.npi,a.idAppointments FROM Appointments a LEFT JOIN Clients c ON c.idClients=a.idAppointments;

--Inner
SELECT * FROM Cards INNER JOIN Accounts WHERE idCards=2;
SELECT * FROM Clients JOIN Owner INNER JOIN Accounts ON idAccounts=2;
SELECT * FROM Owner INNER JOIN Phones ON idOwner=1;
SELECT a.balance,a.cbu,c.idClients FROM Clients c INNER JOIN Accounts a on a.idAccounts=c.idClients;
SELECT a.balance,a.cbu,c.number FROM Cards c INNER JOIN Accounts a WHERE a.idAccounts=1;