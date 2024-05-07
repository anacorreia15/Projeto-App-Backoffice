// Adiciona um listener para o evento de mudança do input de data
document.getElementById('semana').addEventListener('change', function() {
    // Obtém o valor da data selecionada
    var selectedDate = this.value;
    // Redireciona para a página desejada passando a data como parâmetro
    window.location.href = '/geral/visualizarData?data=' + selectedDate;
});

document.getElementById('mes').addEventListener('change', function() {
    // Obtém o valor da data selecionada
    var selectedDate = this.value;
    // Redireciona para a página desejada passando a data como parâmetro
    window.location.href = '/geral/visualizarData?data=' + selectedDate;
});
