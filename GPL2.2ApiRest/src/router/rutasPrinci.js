const express = require('express');
const UseController=require('../controllers/usecontroller');
const router = express.Router();

//!rutas
router.get('/',UseController.list);
router.get('/get_dato',UseController.get);
router.post('/add_dato',UseController.save);
router.put('/update_dato/:id',UseController.update);
router.delete('/delete_dato/:id',UseController.delete);


module.exports=router;