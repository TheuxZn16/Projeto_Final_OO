# # 🚗 Projeto Final - Sistema de Corridas (OO)

Este projeto implementa um **sistema de corridas semelhante ao Uber**, utilizando os princípios da **Programação Orientada a Objetos (POO)**.  
O sistema foi desenvolvido em **Java** e tem como objetivo demonstrar o uso de **classes, herança, polimorfismo, encapsulamento, exceções personalizadas e associações entre objetos.**

---

## 📁 Estrutura do Repositório

```
.
│
├── 📁 src/
│   ├── 📁 entidades/
│   │   ├── Usuario.java
│   │   ├── Passageiro.java
│   │   ├── Motorista.java
│   │   ├── Veiculo.java
│   │   ├── Corrida.java
│   │   ├── MetodoPagamento.java
│   │   ├── PagamentoCartao.java
│   │   ├── PagamentoPix.java
│   │   └── PagamentoDinheiro.java
│   │
│   ├── 📁 servicos/
│   │   └── ServicoCorrida.java
│   │
│   ├── 📁 excecoes/
│   │   ├── SaldoInsuficienteException.java
│   │   ├── PagamentoRecusadoException.java
│   │   ├── NenhumMotoristaDisponivelException.java
│   │   ├── EstadoInvalidoDaCorridaException.java
│   │   ├── PassageiroPendenteException.java
│   │   └── MotoristaInvalidoException.java
│   │
│   └── Main.java
│
├── 📁 docs/
│   ├── Projeto_Final_OO_Explicacoes.pdf
│   ├── Projeto_Final_OO_UML.png
│   └── Projeto_Final_OO_UML_EDITAVEL.drawio
│
├── README.md
├── .gitignore
└── LICENSE (opcional)

```

---

## 🧠 Funcionalidades Principais

- Cadastro de **usuários, motoristas e veículos**
- Solicitação e finalização de **corridas**
- Processamento de **pagamentos** via múltiplos métodos (Pix, Cartão, Dinheiro)
- Tratamento de **exceções personalizadas**
- Aplicação dos **princípios da orientação a objetos**

---

## 🧱 Diagrama UML

O diagrama completo das classes e associações está disponível em:

- 📄 `/docs/Projeto_Final_OO_UML.png`  
- 🧩 `/docs/Projeto_Final_OO_UML_EDITAVEL.drawio` (editável no [Draw.io](https://app.diagrams.net))

---

## 🧾 Documentação Explicativa

A explicação detalhada de cada **classe, associação e exceção personalizada** está disponível no PDF:

📘 `/docs/Projeto_Final_OO_Explicacoes.pdf`

---

## 🧪 Como Executar

1. Clone este repositório:
   ```bash
   git clone https://github.com/TheuxZn16/Projeto_Final_OO.git
   cd Projeto_Final_OO/src
   ```

2. Compile o projeto:

   ```bash
   javac *.java excecoes/*.java
   ```

3. Execute:

   ```bash
   java Main
   ```

---

## 🧑‍💻 Tecnologias Utilizadas

* Linguagem: **Java**
* Ferramenta UML: **Draw.io**
* Controle de versão: **Git + GitHub**

---

## ⚖️ Licença

Este projeto está licenciado sob a **MIT License** — veja o arquivo [LICENSE](../LICENSE) para mais detalhes.

---

## ✨ Autores

**Matheus Estevam - 251013651**
📆 Projeto desenvolvido como trabalho final da disciplina de **Orientação a Objetos**.

