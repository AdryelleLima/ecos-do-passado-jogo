# 🕯️ Ecos do Passado: O Segredo da Casa Abandonada (Protótipo / MVP)

> **Status do Projeto:** 🚧 **Em Desenvolvimento Ativo & Polimento de Lógicas**  
> *Implementando interações dinâmicas, posicionamento de itens e preparando a bateria de testes de fluxo.*

## 📖 Sobre o Projeto
**Ecos do Passado** é um jogo interativo focado em narrativa, exploração baseada em comandos e suspense psicológico. O jogador assume o papel de um investigador que entra em uma casa abandonada ligada a acontecimentos misteriosos de 1984, devendo explorar os cômodos, resolver quebra-cabeças mecânicos e desvendar fitas de áudio para progredir.

Este repositório contém a versão **MVP (Produto Mínimo Viável)** do projeto, com foco no aprendizado da linguagem Java, aplicação de Orientação a Objetos (POO) e construção do portfólio pessoal.

---

## 🛠️ Estado Atual do Desenvolvimento

O projeto está na fase de construção de mecânicas de fundo e validação de regras de negócio. 

### 🟢 Implementado / Em Estruturação
- **Estrutura Base:** Loop principal do jogo, menu e configurações de interface do terminal.
- **Mapeamento do Mundo:** Conexões de salas via grafo e sistema de navegação por direções.
- **Parser de Comandos:** Leitura e interpretação de ações (`ir`, `pegar`, `usar`, `examinar`).
- **Sistema de Salvamento:** Estrutura para leitura e escrita de estado (`.txt`).

### 🟡 Em Implementação & Ajustes Finos (Work in Progress)
- **Mudanças Dinâmicas de Cenário:** Criação de descrições condicionais para transições de ambiente (ex: evento/transição ao usar a escada, alteração do texto ao subir/descer).
- **Gerenciamento de Portas e Chaves:** Lógica de transição de estado das portas (trancada vs. destrancada) e respostas dinâmicas no terminal.
- **Distribuição e Interação de Itens:** Posicionamento definitivo dos itens nas salas corretas e vinculação com o `GerenciadorInteracao`.
- **Worldbuilding & Texto:** Escrita das descrições detalhadas das salas, móveis, papéis e itens.

### 🔴 Próximos Passos
- [ ] Finalizar o posicionamento e as descrições de todos os itens no `Main`.
- [ ] Executar bateria de testes integrados para validar a lógica das chaves e puzzles.
- [ ] Testar o fluxo completo de gameplay do início ao fim (game loop).

---

## 🎮 Mapeamento de Comandos (Parser)
* **Navegação:** `ir [direção]`, `entrar [sala]`, `subir`, `descer`
* **Exploração:** `examinar [alvo]`, `olhar [item]`, `ler [documento]`
* **Ações:** `pegar [item]`, `usar [item]`, `abrir [porta]`, `ligar [gerador]`
* **Sistema:** `mochila`, `salvar`, `sair`
---

## 🛠️ Tecnologias Utilizadas
- **Linguagem:** Java 17+ (LTS)
- **Paradigma:** Programação Orientada a Objetos (POO)
- **Interface:** CLI / Terminal
- **Persistência de Dados:** Manipulação de arquivos locais `.txt` (Java I/O)
- **IDE:** Visual Studio Code (VS Code)

---

## 📁 Estrutura do Repositório
```text
ecos-do-passado/
├── src/
│   ├── Comando.java               # Encapsula ação e alvo do jogador
│   ├── Configuracao.java          # Efeitos de terminal, velocidade e limpar tela
│   ├── GerenciadorInteracao.java  # Regras de puzzles (gerador, fitas, chaves)
│   ├── GerenciadorSave.java       # Leitura e escrita de saves (.txt)
│   ├── Item.java                  # Representação de itens, textos e ocultações
│   ├── Jogador.java               # Estado do jogador, localização e inventário
│   ├── Main.java                  # Loop principal e inicialização do mundo
│   ├── Parser.java                # Processamento e interpretação de texto
│   └── Sala.java                  # Mapeamento de salas, saídas e trancas
├── saves/                         # Arquivo de progresso do jogador (save.txt)
└── README.md                      # Documentação do repositório
