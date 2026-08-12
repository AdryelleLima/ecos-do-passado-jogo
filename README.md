# 🕯️ Ecos do Passado: O Segredo da Casa Abandonada (Protótipo / MVP)

> **Status do Projeto:** 🛠️ Em desenvolvimento ativo (Mecânicas core finalizadas; polimento narrativo e descrições em andamento).

## 📖 Sobre o Projeto
**Ecos do Passado** é um jogo interativo focado em narrativa, exploração baseada em comandos e suspense psicológico. O jogador assume o papel de um investigador que entra em uma casa abandonada ligada a acontecimentos misteriosos de 1984, devendo explorar os cômodos, resolver quebra-cabeças mecânicos e desvendar fitas de áudio para progredir.

Este repositório contém a versão **MVP (Produto Mínimo Viável)** do projeto, com foco no aprendizado da linguagem Java, aplicação de Orientação a Objetos (POO) e construção do portfólio pessoal.

---

## 🎯 Objetivos do MVP (Status do Desenvolvimento)
A arquitetura principal do jogo já se encontra funcional, operando via terminal com parser de comandos e gerenciamento de estado:

- [x] **Estrutura inicial em Java:** Menu principal, configurações de velocidade de texto e suporte a terminal retrô.
- [x] **Navegação de Salas (Grafo):** Sistema completo de movimentação entre cômodos (Sacada, Hall, Cozinha, Porão, Escritório, etc.).
- [x] **Sistema de Inventário e Inspeção:** Coleta de itens (`Chaves`, `Galão de Gasolina`, `Pilhas`, `Gravador de Áudio`, `Fitas Cassete`).
- [x] **Mecânicas Interativas (`GerenciadorInteracao`):**
  - [x] Encaixe de pilhas e reprodução de fitas cassete no gravador.
  - [x] Abastecimento e ativação do gerador no porão.
  - [x] Sistema de portas e fechaduras trancadas.
  - [x] Móveis com itens ocultos/escondidos.
- [x] **Persistência de Dados (Save/Load):** Salvamento e carregamento automático do progresso e inventário em arquivo `.txt`.
- [ ] **Polimento Narrativo (Em andamento):** Finalização e detalhamento das descrições das salas, documentos e transcrições das fitas de áudio.

---

## 🎮 Comandos Reconhecidos pelo Parser
O jogo conta com um analisador léxico (`Parser`) que aceita múltiplos verbos para cada ação:

- **Movimentação:** `ir [direção]`, `entrar [sala]`, `caminhar [direção]`
- **Exploração:** `examinar [item/móvel]`, `olhar [item]`, `ler [documento]`
- **Coleta:** `pegar [item]`, `coletar [item]`, `guardar [item]`
- **Interação:** `usar [item]`, `colocar [item]`, `ligar [gerador]`, `abrir [porta]`
- **Gerenciamento:** `mochila` / `inventario`, `salvar`, `sair`

---

## 🚀 Próximas Implementações (Roadmap)
Após a conclusão dos textos e descrições dos ambientes, o desenvolvimento avançará para:

- 📜 **Finalização da Lore:** Conclusão da gravação da Fita Cassete #04 e refinamento dos diários/bilhetes.
- 🔊 **Ambiente Sonoro (Áudio em `.wav`):** Integração de efeitos sonoros (ruídos de fita, ranger de portas, gerador).
- ♿ **Recursos de Acessibilidade:** Suporte a leitores de tela e comandos simplificados.

---

## 🛠️ Tecnologias Utilizadas
- **Linguagem:** Java 17+ (LTS)
- **Paradigma:** Programação Orientada a Objetos (POO)
- **Persistência de Dados:** Manipulação de arquivos locais `.txt` (Java I/O)
- **IDE:** Visual Studio Code (VS Code)

---

## 📁 Estrutura do Repositório
```text
ecos-do-passado/
├── src/
│   ├── Comando.java               # Encapsula ação e alvo do jogador
│   ├── Configuracao.java          # Efeitos de terminal, velocidade e limpar tela
│   ├── GerenciadorInteracao.java # Regras de puzzles (gerador, fitas, chaves)
│   ├── GerenciadorSave.java      # Leitura e escrita de saves (.txt)
│   ├── Item.java                  # Representação de itens, textos e ocultações
│   ├── Jogador.java               # Estado do jogador, localização e inventário
│   ├── Main.java                  # Loop principal e inicialização do mundo
│   ├── Parser.java                # Processamento e interpretação de texto
│   └── Sala.java                  # Mapeamento de salas, saídas e trancas
├── saves/                         # Arquivo de progresso do jogador (save.txt)
└── README.md                      # Documentação do repositório
