const mysqlConnection = require("../util/database");
const controller = {};

// GET all
controller.list = (req, res) => {
  console.log("Listado");
  mysqlConnection.query("SELECT * FROM usuario", (err, rows, fields) => {
    if (!err) {
      res.json({
        status_code: 202,
        message: "Listado",
        usuario: rows,
        //authData
      });
      console.log(rows);
    } else {
      res.json({
        code: 500,
        error: true,
        message: err,
      });
    }
  });
};

// GET An
controller.get = (req, res) => {
  const { id } = req.params;
  mysqlConnection.query(
    "SELECT * FROM usuario WHERE id = ?",
    [id],
    (err, rows, fields) => {
      if (!err) {
        res.json(rows[0]);
      } else {
        console.log(err);
        res.json({
          code: 500,
          error: true,
          message: err,
        });
      }
    }
  );
};
//INSERT
controller.save = (req, res) => {
  const { nombre, apellido, email } = req.body;
  //console.log(req);
  console.log(nombre, apellido, email);
  const query = `INSERT INTO usuario(nombre, apellido, email)
VALUES(?,?,?)`;
  mysqlConnection.query(query, [nombre, apellido, email], (err, rows, fields) => {
    if (!err) {
      res.json({
        error: false,
        message: " Saved",
      });
    } else {
      res.json({
        error: true,
        message: err,
      });
      console.log(err);
    }
  });
};
// UPDATE
controller.update = (req, res) => {
  const { nombre, apellido, email } = req.body;
  const { id } = req.params;
  console.log(id, nombre, apellido, email);
  //const query = `SET @id = ?; SET @nombre = ?; SET @email = ?; SET
  // @edad = ?; CALL employeeAddOrEdit(@id, @nombre, @email,@edad);`;
  const query = `UPDATE usuario SET nombre=?, apellido=?,email=? WHERE
id=?;`;
  mysqlConnection.query(query, [nombre, apellido, email, id], (err, rows, fields) => {
    if (!err) {
      res.json({
        code: 200,
        error: false,
        message: " Updated",
      });
    } else {
      console.log(err);
      res.json({
        code: 500,
        error: true,
        message: err,
      });
    }
  });
};
// DELETE
controller.delete = (req, res) => {
  const { emp_id } = req.params;
  mysqlConnection.query(
    "DELETE FROM usuario WHERE id = ?",
    [emp_id],
    (err, rows, fields) => {
      if (!err) {
        res.json({
          code: 200,
          error: false,
          message: " Deleted",
        });
      } else {
        console.log(err);
        res.json({
          code: 500,
          error: true,
          message: err,
        });
      }
    }
  );
};
module.exports = controller;
