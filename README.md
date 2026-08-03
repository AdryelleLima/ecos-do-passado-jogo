# 🕯️ Ecos do Passado: O Segredo da Casa Abandonada (Protótipo / MVP)

> **Status do Projeto:** 🛠️ Em desenvolvimento inicial (Fase de prototipagem e lógica básica).

## 📖 Sobre o Projeto
**Ecos do Passado** é um jogo interativo focado em narrativa, exploração baseada em comandos e suspense psicológico. O jogador assume o papel de um estudante universitário que entra em uma casa abandonada próxima a um antigo acampamento e precisa investigar os mistérios do local enquanto busca uma forma de escapar.

Este repositório contém a versão **MVP (Produto Mínimo Viável)** do projeto, com foco no aprendizado da linguagem Java, aplicação de Orientação a Objetos (POO) e construção do portfólio pessoal.

---

## 🎯 Objetivos do MVP (Escopo Atual)
Nesta fase inicial, o foco do projeto é implementar a arquitetura essencial de funcionamento via terminal:

- [x] Estrutura inicial do projeto em Java.
- [ ] Sistema de navegação entre cômodos (rede/grafo de salas).
- [ ] Sistema de inventário e inspeção de itens (`Lanterna`, `Chaves`, `Documentos`).
- [ ] Condicionais de exploração (fechaduras, objetos emperrados e passagens).
- [ ] Persistência de dados básica (Salvamento/Carregamento do estado em arquivo `.txt`).

---

## 🚀 Próximas Implementações (Roadmap)
Após a consolidação da lógica principal e navegação do jogo, o desenvolvimento avançará para os seguintes recursos:

- 🔊 **Ambiente Sonoro (Áudio em `.wav`):** Efeitos de gatilho sonoro (ranger de madeira, vento, trancas de portas) para aumentar a imersão do jogador.
- 📜 **Expansão Narrativa:** Textos descritivos completos, relatórios do caso de desaparecimento e cartas ocultas.
- ♿ **Recursos de Acessibilidade:** Implementação de narração nativa / suporte a audiolivro interativo.

---

## 🛠️ Tecnologias Utilizadas
- **Linguagem:** Java 17+ (LTS)
- **Paradigma:** Programação Orientada a Objetos (POO)
- **Persistência de Dados:** Manipulação de arquivos locais `.txt` (I/O Java)
- **IDE:** Visual Studio Code (VS Code)

---

## 📁 Estrutura do Repositório
```text
ecos-do-passado/
├── src/                  # Código-fonte em Java (Classes, Lógica)
├── saves/                # Diretório para gravações do jogo (.txt)
└── README.md             # Documentação do repositório