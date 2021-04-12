function doLogin(form) {
  event.preventDefault();
  var logou;

  var userList = [
    {
      nome: "Paulo",
      senha: "123",
    },
    {
      nome: "Joana",
      senha: "123",
    },
    {
      nome: "Fernando",
      senha: "123",
    },
    {
      nome: "Vitória",
      senha: "123",
    },
    {
      nome: "Pedro",
      senha: "123",
    },
    {
      nome: "Letícia",
      senha: "123",
    },
  ];

  if (form.usuario.value == "") {
    document.getElementById("errousuario").style.display = "block";
    return false;
  } else {
    document.getElementById("errousuario").style.display = "none";
  }

  if (form.senha.value == "") {
    document.getElementById("errosenha").style.display = "block";
    return false;
  } else {
    document.getElementById("errosenha").style.display = "none";
  }

  for (var i = 0; i < userList.length; i++) {
    if (
      (form.usuario.value == userList[i].nome) &
      (form.senha.value == userList[i].senha)
    ) {
      location.href = "../index.html";
      localStorage.setItem("username", userList[i].nome);
      logou = true;

      break;
    }
  }
  if (!logou) {
    document.getElementById("error").style.display = "block";
    return false;
  }
}
