function checaLogin() {
    if (localStorage.getItem("username") != "" & localStorage.getItem("username") != null) {
      
      document.getElementById("logado").innerHTML =
        "<a id='user' class='nav-link dropdown-toggle' data-toggle='dropdown' href='#'>Login <i class='fas fa-user-circle'></i></a>" +
        "<div class='dropdown'><ul class='dropdown-menu dropdown-menu-right' aria-expanded='false'> <li><a onClick='clickPerfil()' class='dropdown-item' href='#'>Perfil</a></li> <li><a onClick='logout()' class='dropdown-item' href='#'>Sair</a></li></ul></div>";
    }
    else{
      document.getElementById("logado").innerHTML = "<a id='user' class='nav-link' href='../login/login.html'>Login <i class='fas fa-user-circle'></i></a>"
    }
  }  
  checaLogin();


dadosDoUsuario = () => {
  if (localStorage.getItem("username") != "" & localStorage.getItem("username") != null) {
    document.getElementById("user").innerHTML = `Olá,  
    ${localStorage.getItem(
      "username"
    )}  <i class='fas fa-user-circle'></i></a>`;
  }
};

dadosDoUsuario();

function clickPerfil() {
  const usersList = [
    {
      nome: "Paulo",
      perfil: "../profiles/profile1.html",
    },
    {
      nome: "Joana",
      perfil: "../profiles/profile2.html",
    },
    {
      nome: "Fernando",
      perfil: "../profiles/profile3.html",
    },
    {
      nome: "Vitória",
      perfil: "../profiles/profile4.html",
    },
    {
      nome: "Pedro",
      perfil: "../profiles/profile5.html",
    },
    {
      nome: "Letícia",
      perfil: "../profiles/profile6.html",
    },
  ];

  const usuario = usersList.find(
    (user, index, array) => user.nome === localStorage.getItem("username")
  );

  if (usuario != null) {
    location.href = usuario.perfil;
  } else {
    location.href = "../login/login.html";
  }
}

function logout() {
  localStorage.setItem("username", "");
  location.href = "../index.html";
}


