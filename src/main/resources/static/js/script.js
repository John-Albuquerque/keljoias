const API_URL = "/api/produtos";

document.addEventListener("DOMContentLoaded", () => {
    carregarProdutos();
});

function carregarProdutos() {
    fetch(API_URL)
        .then(response => response.json())
        .then(produtos => renderizar(produtos))
        .catch(() => {
            document.getElementById("produtos")
                .innerHTML = "<p>Erro ao carregar produtos</p>";
        });
}

function renderizar(produtos) {
    const container = document.getElementById("produtos");
    container.innerHTML = "";

    produtos.forEach(produto => {
        const card = document.createElement("div");
        card.className = "produto-card";

        card.innerHTML = `
            <img src="${produto.imagemUrl}" alt="${produto.nome}">
            <h3>${produto.nome}</h3>
            <p>${produto.descricao}</p>
            <strong>R$ ${produto.preco.toFixed(2)}</strong>
            <button onclick="comprar(${produto.id})">
                Comprar com Pix
            </button>
        `;

        container.appendChild(card);
    });
}

function comprar(id) {
    alert("Produto selecionado (ID: " + id + ")");
}
