const express=require('express');
const app = express();


app.set('port',process.env.PORT || 3000)


app.use(express.json())
app.use(express.urlencoded({extended:false}))

const route=app.use(require('./router/rutasPrinci'))
app.listen(app.get('port'),()=>{
  console.log(`El servidor esta en el puerto  ${app.get('port')}`);
})