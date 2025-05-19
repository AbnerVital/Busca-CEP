# 📍 Busca-CEP - Consulta de Endereços por CEP em Java

Este projeto é um exemplo de aplicação Java que realiza consultas de endereços a partir de CEPs utilizando a API pública ViaCEP. Ele serve como base para projetos que necessitam integrar funcionalidades de busca de endereços por CEP.

---

## 🧠 Objetivo

Demonstrar como:

- Fazer requisições HTTP em Java sem bibliotecas externas;
- Trabalhar com respostas no formato JSON;
- Estruturar projetos simples com separação de responsabilidades;
- Integrar aplicações Java com APIs públicas (neste caso, a API ViaCEP).

---

## ⚙️ Tecnologias Utilizadas

- **Java 17+**
- **API ViaCEP** (https://viacep.com.br/)
- **IDE IntelliJ IDEA** (ou qualquer IDE de sua preferência)

---

## 🧱 Estrutura do Projeto

```

📁 Busca-CEP/
├── 📁 .idea/
├── 📁 src/
│   └── 📁 br/
│       └── 📁 com/
│           └── 📁 alura/
│               └── 📁 buscaCEP/
│                   ├── 📄 Main.java
│                   ├── 📄 CepService.java
│                   └── 📄 Endereco.java
├── 📄 .gitignore
├── 📄 Busca CEP.iml
└── 📄 README.md

````

## 🛠️ Como Executar o Projeto

1. **Clone o repositório**:

    ```bash
       git clone https://github.com/AbnerVital/Busca-CEP.git
       cd Busca-CEP
    ````

2. **Compile os arquivos Java**:

   ```bash
   javac src/br/com/alura/buscaCEP/*.java
   ```

3. **Execute o programa**:

   ```bash
   java -cp src br.com.alura.buscaCEP.Main
   ```

   > **Nota**: Certifique-se de estar utilizando o Java 17 ou superior.

## 📈 Melhorias Futuras

* Implementar tratamento de exceções mais robusto para lidar com erros de rede ou CEPs inválidos.
* Adicionar interface gráfica para facilitar a interação com o usuário.
* Integrar com outras APIs de CEP para ampliar a cobertura de dados.

## 👨‍💻 Autor

| [<img src="https://avatars.githubusercontent.com/u/102125924?v=4" width=115><br><sub>Abner Vital</sub>](https://github.com/AbnerVital) |
| :------------------------------------------------------------------------------------------------------------------------------------: |


## 📫 Contato

* **LinkedIn**: [@Abner Vital](https://www.linkedin.com/in/abner-vital-233730141/)
* **GitHub**: [@AbnerVital](https://github.com/AbnerVital)

---

> Desenvolvido durante os estudos na [Alura](https://www.alura.com.br/)
