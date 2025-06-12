
const express = require('express');
const axios = require('axios');
const app = express();

app.use(express.urlencoded({ extended: true }));
app.set('view engine', 'ejs');

const BACKEND_URL = process.env.BACKEND_URL || 'http://localhost:8080';

app.get('/', (req, res) => {
  res.render('form');
});

app.post('/simular', async (req, res) => {
  try {
    const response = await axios.post(`${BACKEND_URL}/api/simular`, {
      valor: parseFloat(req.body.valor),
      meses: parseInt(req.body.meses),
      taxa: parseFloat(req.body.taxa)
    });
    res.render('resultado', { resultado: response.data });
  } catch (error) {
    res.send("Erro ao simular empréstimo.");
  }
});

app.listen(8000, () => {
  console.log("Frontend rodando na porta 8000");
});


app.get('/simulacoes', async (req, res) => {
  try {
    const response = await axios.get(`${BACKEND_URL}/api/historico`);
    res.render('lista', { simulacoes: response.data });
  } catch (error) {
    res.send("Erro ao buscar histórico de simulações!");
  }
});
