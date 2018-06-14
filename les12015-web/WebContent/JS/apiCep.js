let data = {}
let cep = document.getElementById("txtCep");
cep.addEventListener("input", () => {
  if (cep.value.length == 8) {
    request(cep.value)
      .then(json => {
        document.getElementById("txtRua").value = json.logradouro
        document.getElementById("txtBairro").value = json.bairro
        document.getElementById("txtCidade").value = json.localidade
        document.getElementById("txtEstado").value = json.uf
      })
      .catch(reason => console.log(reason.message));
  }
})

const request = async cep => {
  const response = await fetch(`https://viacep.com.br/ws/${cep}/json/`);
  return await response.json();
};

