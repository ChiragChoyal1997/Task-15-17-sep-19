# Task-15-17-sep-19

------------------------------------------------------------Triggers ------------------------------------------------------------

on deleting employee delete entries of employee_project table
---------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE TRIGGER delete_emp
	AFTER DELETE ON employee
	FOR EACH ROW
	BEGIN
	DELETE employee_project WHERE EMPLOYEELIST_ENO = :OLD.eno;
END delete_emp;
----------------------------------------------------------------------------------------------------------------------------------

On deleting laptop set null to laptop field in employee table to which laptop was assigned
----------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE TRIGGER delete_laptop
	AFTER DELETE ON laptop
	FOR EACH ROW
	BEGIN
	UPDATE employee SET laptop_code=null WHERE laptop_code = :OLD.code;
END delete_laptop;
-----------------------------------------------------------------------------------------------------------------------------------

On deleting vehicle set null to vehicle field in employee table who were traveling by that particular vehicle.
------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE TRIGGER delete_vehicle
	AFTER DELETE ON vehicle
	FOR EACH ROW
	BEGIN
	UPDATE employee SET vehicle_vehicle_id=null WHERE vehicle_vehicle_id = :OLD.vehicle_id;
END delete_vehicle;
------------------------------------------------------------------------------------------------------------------------------------

On deleting or completion of project release employee who were assigned that project by deleting the entry of employee_project table.
-------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE TRIGGER delete_project
	AFTER DELETE ON project
	FOR EACH ROW
	BEGIN
	DELETE employee_project WHERE projectlist_pno = :OLD.pno;
END delete_project;
-------------------------------------------------------------------------------------------------------------------------------------
