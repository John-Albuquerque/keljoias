// Endpoint da API Spring Boot
const API_URL = "/api/produtos";

// Quando o HTML terminar de carregar
document.addEventListener("DOMContentLoaded", () => {
    buscarProdutos();
});

/**
 * Busca os produtos no backend Java
 */
function buscarProdutos() {
    fetch(API_URL)
        .then(resposta => {
            if (!resposta.ok) {
                throw new Error("Erro ao buscar produtos");
            }
            return resposta.json();
        })
        .then(produtos => {
            renderizarProdutos(produtos);
        })
        .catch(erro => {
            console.error(erro);
            mostrarMensagem("Erro ao carregar produtos.");
        });
}

/**
 * Renderiza os produtos na tela
 */
function renderizarProdutos(produtos) {
    const container = document.getElementById("produtos");

    container.innerHTML = "";

    if (produtos.length === 0) {
        container.innerHTML = "<p>Nenhum produto cadastrado.</p>";
        return;
    }

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

/**
 * Simula a compra (Pix entra depois)
 */
function comprar(produtoId) {
    alert(
        "Produto selecionado (ID: " + produtoId + ")\n" +
        "Pagamento via Pix será integrado em breve 💸"
    );
}

/**
 * Mostra mensagem simples na tela
 */
function mostrarMensagem(texto) {
    const container = document.getElementById("produtos");
    container.innerHTML = `<p>${texto}</p>`;

}
console.log("Script foi carregado!")