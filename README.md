# Projeto FiapRide - Fernando Pimentel Soriano

## Informações do Aluno

- **Nome:** Fernando Pimentel Soriano
- **RM:** 563716
- **Turma:** 2CCPX
- **Curso:** Ciência da Computação - 3º semestre
- **GitHub:** [FernandopSoriano]

---

## Descrição do Projeto

Este projeto é o resultado do aprendizado nas aulas 1-9 de Programação Orientada a Objetos, onde desenvolvemos o sistema **FiapRide** (aplicativo de mobilidade urbana).

A ideia é simular, em pequena escala, como seria a modelagem de um app tipo Uber/99: temos passageiros com saldo, uma frota de veículos (carros, motos e até carro elétrico) e viagens que conectam um passageiro a um veículo, descontando o valor da corrida do saldo do usuário.

Estrutura de pastas:

```
poo-fiapride-patricia/
├── src/
│   └── br/
│       └── com/
│           ├── fiapride/
│           │   ├── Main.java
│           │   ├── interfaces/
│           │   │   └── Recarregavel.java
│           │   └── model/
│           │       ├── Passageiro.java
│           │       ├── Veiculo.java     (abstrata)
│           │       ├── Carro.java
│           │       ├── Moto.java
│           │       ├── CarroEletrico.java
│           │       └── Viagem.java
│           └── projetopessoal/
│               └── biblioteca/          (projeto pessoal extra)
│                   ├── MainBiblioteca.java
│                   └── model/
│                       ├── Livro.java
│                       ├── Usuario.java
│                       └── Emprestimo.java
├── README.md
└── .gitignore
```

### Como rodar

```bash
cd src
javac br/com/fiapride/Main.java
java br.com.fiapride.Main
```

---

## Checklist de Implementação

- [x] Aula 1 - Classes e Objetos
- [x] Aula 2 - Métodos
- [x] Aula 3 - Encapsulamento
- [x] Aula 4 - Construtores
- [x] Aula 5 - Associação
- [x] Aula 6 - Herança
- [x] Aula 7 - Polimorfismo
- [x] Aula 8 - Classes Abstratas
- [x] Aula 9 - Interfaces

---

## Perguntas de Reflexão

### Aula 1 - Classes e Objetos

**Pergunta:** Por que precisamos criar uma classe `Passageiro`? Não seria mais fácil apenas criar variáveis soltas no main, como `String nomeAna = "Ana"` e `double saldoAna = 50.0`? E se o FiapRide tiver 1 milhão de usuários?

**Sua Resposta:**
No começo eu confesso que achei meio "frescura" criar uma classe inteira só pra guardar nome e saldo de alguém. Mas conforme fui escrevendo o código eu entendi que, com variáveis soltas no main, eu teria que repetir `nomeAna`, `saldoAna`, `cpfAna`, `nomeBruno`, `saldoBruno`, `cpfBruno`… e isso pra 2 pessoas já fica feio, imagina pra 1 milhão. Com a classe `Passageiro` eu crio um "molde" e instancio quantos objetos quiser, cada um com seus próprios atributos guardados juntinhos. Além disso, se um dia eu precisar adicionar um campo novo (tipo `cartaoCredito`), eu mexo num lugar só. O nome técnico disso, segundo o professor, é "abstração": a classe é o conceito, e cada objeto é uma instância real dele.

---

### Aula 2 - Métodos

**Pergunta:** Se podemos simplesmente fazer `passageiro.saldo = passageiro.saldo + 100` diretamente, por que dá tanto trabalho criar um método `adicionarSaldo(valor)`?

**Sua Resposta:**
Porque no método eu consigo colocar regras. No meu `adicionarSaldo()` eu checo se o valor é maior que zero antes de somar — se alguém tentar `adicionarSaldo(-30)`, o método recusa e imprime erro. Se eu deixasse `passageiro.saldo = passageiro.saldo - 30` no main, o saldo ficaria negativo e ninguém percebia. Pensando como startup de mobilidade: imagine se um programador novo, sem querer, somasse valor negativo numa recarga, ou pior, fizesse `saldo = saldo + valorErrado` por causa de um bug no cálculo. Como o método é o "porteiro" do atributo, ele garante que **nenhuma alteração ilegal acontece**, e fica fácil achar o problema porque toda mudança passa pelo mesmo lugar.

---

### Aula 3 - Encapsulamento

**Pergunta:** Os atributos são `private`, mas `getSaldo()` e `getNome()` são `public`. Por que é seguro o get ser público mas perigoso o atributo ser?

**Sua Resposta:**
A analogia do documento original vs. cópia me ajudou demais. O `get` devolve uma cópia do valor: se eu pego `ana.getSaldo()` e guardo numa variável local, mexer nessa variável **não muda** o saldo da Ana. Já se o atributo `saldo` fosse público, qualquer parte do código poderia escrever `ana.saldo = 0` direto e zerar a conta dela. O `private` no atributo + `public` no getter dá o melhor dos dois mundos: deixo as outras classes consultarem o valor (precisa pra exibir na tela, calcular coisas etc.) mas **forço quem quiser modificar a passar pelos métodos** que eu mesma escrevi (com validação). É tipo o caixa eletrônico: você consegue ver o saldo, mas não consegue alterá-lo sem passar pelas regras do banco.

---

### Aula 4 - Construtores

**Pergunta:** Por que não criamos `setModelo()` e por que `setPlaca()` é privado, com um `atualizarPlaca()` público no lugar? Por que clicar em "Gerar Getters e Setters" automaticamente é perigoso?

**Sua Resposta:**
Eu já tinha o costume de mandar a IDE gerar todos os getters e setters de uma vez. Depois dessa aula eu mudei de ideia. O modelo de um carro **não muda na vida real** — um Fiat Mobi não vira um Tesla porque alguém setou outra string. Então criar `setModelo()` é abrir uma porta que **não deveria existir**, e isso pode esconder bugs absurdos. Já a placa pode mudar (Detran, batida etc.), mas é um processo, não é só trocar uma string: tem que ter motivo, registro, validação. Por isso o `setPlaca()` ficou privado e o `atualizarPlaca(novaPlaca, motivo)` é o método público que obriga a passar o motivo. Resumindo: o setter automático trata o sistema como um banco de dados burro; os métodos pensados tratam como **processo de negócio**.

---

### Aula 5 - Associação

**Pergunta:** Por que no construtor da Viagem exigimos o objeto `Passageiro` inteiro, e não só uma `String nomeDoPassageiro`?

**Sua Resposta:**
Eu testei mentalmente: se a Viagem só tivesse a string `"Ana Silva"`, na hora de finalizar a viagem eu não teria como cobrar — uma string não tem saldo, não tem método `descontarSaldo()`. Eu teria que sair procurando o passageiro pelo nome em algum lugar (e ainda corria o risco de ter dois "Ana Silva" cadastrados, virava uma bagunça). Tendo o objeto `Passageiro` inteiro, a Viagem fala direto com ele: `solicitante.descontarSaldo(valor)`. A associação faz com que os objetos **conversem entre si**, e cada um cuida da sua parte. É uma das coisas mais legais de POO que vi até agora — o código fica meio "vivo".

---

### Aula 6 - Herança

**Pergunta:** Por que o `Carro` (filho) não consegue mexer direto em `placa` mesmo herdando de `Veiculo`?

**Sua Resposta:**
Porque o `private` da mãe protege o atributo **inclusive contra os filhos**. No começo isso me pareceu estranho ("mas eu sou filha, eu deveria ter acesso!"), mas faz sentido: se a mãe `Veiculo` decidiu que a placa só muda passando pelo `setPlaca()` (com validação de tamanho, etc.), deixar o filho ignorar isso quebraria toda a regra. O princípio que está sendo protegido é o **encapsulamento da Aula 3**: a mãe cria regras de como tratar seus próprios dados, e a herança não pode ser uma "porta dos fundos" pra burlar essas regras. Quando eu *quero* dar acesso direto pro filho, uso `protected` (foi o que fiz com `ano`, porque ele não tem regra nenhuma de validação).

---

### Aula 7 - Polimorfismo

**Pergunta:** Se esquecêssemos de declarar `calcularAutonomia()` lá na classe `Veiculo`, conseguiríamos chamar esse método dentro do loop `for (Veiculo v : frota)`?

**Sua Resposta:**
Não conseguiria. O Java olha pro **tipo declarado** da variável (no caso `Veiculo`) na hora de compilar e pergunta: "essa classe tem esse método?". Se não tiver, dá erro de compilação, mesmo que na hora da execução o objeto seja um `Carro` que tem o método. Foi exatamente isso que me confundiu no começo. Por isso o método precisa existir na mãe — pode ser abstrato (sem corpo) ou normal, mas precisa estar lá pra "prometer" que toda subclasse vai ter. Esse "promessa" é o que o professor chamou de **contrato**: a mãe garante o nome e a assinatura, e cada filha implementa do jeito dela. Aí o loop funciona pra qualquer veículo, sem o main precisar saber se é Carro, Moto ou Tesla.

---

### Aula 8 - Classes Abstratas

**Pergunta:** Por que `Veiculo` precisa ser `abstract`? Qual o risco de esquecer essa palavra?

**Sua Resposta:**
Faz total sentido só no mundo do código não fazer sentido um "veículo genérico", igual no mundo real ninguém compra "um veículo" — você compra um carro, uma moto, etc. O `abstract` é a forma de eu **avisar ao Java** isso, porque o Java não consegue adivinhar minha intenção: pra ele, `Veiculo` é uma classe normal. Se eu esquecesse o `abstract`, alguém poderia fazer `new Veiculo("ABC-1234", "Genérico", 2024)` e criar um objeto sem sentido na minha frota — e pior, ele não saberia calcular autonomia direito porque o método não existiria de verdade nele. Com `abstract`, o próprio compilador me protege: ele recusa criar instâncias de `Veiculo` direto.

---

### Aula 9 - Interfaces

**Pergunta:** Por que Java permite herdar de só uma classe mas implementar várias interfaces? E como as interfaces resolvem o problema do "diamante" (duas mães com `ligar()`)?

**Sua Resposta:**
A herança simples existe porque, se eu pudesse herdar de duas classes que têm o método `ligar()` implementado de jeitos diferentes, o Java ficaria sem saber qual chamar (isso é o tal "problema do diamante"). Aí o sistema travaria em decisões ambíguas. As interfaces resolvem isso porque **elas não têm implementação** (ou têm só `default`, controlada). Elas só dizem "quem me usa precisa ter esse método", e quem implementa escreve **uma única versão** do `ligar()` na própria classe. Mesmo que eu implemente 5 interfaces que pedem `ligar()`, só existe uma implementação minha — sem ambiguidade. Foi assim que fiz com `CarroEletrico`: ele **herda** de `Carro` (uma só mãe, sem conflito) e **implementa** `Recarregavel` (contrato extra de bateria).

---

## Desafios Técnicos Implementados

### Desafio Pessoal (Seu Projeto)

**Qual foi o domínio que você escolheu para seu projeto pessoal?**
Sistema simples de Biblioteca - pra praticar os mesmos conceitos num contexto totalmente diferente do FiapRide.

**Quais classes você criou?**
`Livro`, `Usuario` e `Emprestimo` — onde `Emprestimo` faz a associação entre `Livro` e `Usuario`, igualzinho a `Viagem` faz com `Passageiro` e `Veiculo`.

**Qual foi o maior desafio técnico que você enfrentou?**
O maior desafio foi entender quando usar **associação** e quando o atributo poderia ser uma string simples. Eu cometi o erro inicial de fazer a classe `Emprestimo` guardar só o `nomeDoLivro` como String, igual a tentação que o professor descreve na aula 5. Quando fui implementar o método `devolver()`, percebi que eu precisava mudar o status `disponivel` do livro original — e com uma string eu não tinha como, porque a string é só uma cópia do nome, não tem ligação com o objeto real. Refatorei pra guardar o objeto `Livro` inteiro e ficou trivial: `livro.devolver()` resolve. Outro ponto chato foi a parte de validação: no começo eu deixava o livro ser emprestado várias vezes seguidas porque não checava o `disponivel` antes. Adicionei uma validação dentro do método `emprestar()` retornando `false` se já estiver emprestado, e isso me ensinou que **toda regra de negócio precisa ficar dentro do método responsável**, e não espalhada pelo main.

---

## Conclusão

**O que você aprendeu nestas 9 aulas?**
Aprendi que POO não é só uma forma diferente de digitar código — é uma forma diferente de **pensar o problema**. Antes eu programava como se fosse uma receita: passo 1, passo 2, passo 3. Agora eu penso em quem são os "personagens" do sistema, quais são as responsabilidades de cada um e como eles conversam. Mexer no FiapRide foi muito diferente de fazer um exercício de lógica: aqui eu tive que tomar decisões de arquitetura (o setter é público? a classe é abstrata? isso é herança ou associação?), e cada decisão tem consequência. Também entendi por que o pessoal fala tanto de "Clean Code" — quando o código é bem encapsulado, dá pra mudar coisas sem quebrar metade do sistema.

**Qual conceito foi mais difícil de entender?**
Polimorfismo, no começo. A ideia de uma variável do tipo `Veiculo` "virar" um `Carro` ou um `Moto` em tempo de execução me parecia mágica. O que me destravou foi escrever o loop `for (Veiculo v : frota)` e ver que, mesmo o `v` sendo declarado como `Veiculo`, o `v.calcularAutonomia()` chamava a versão certa de cada filha. Aí caiu a ficha: o tipo declarado define o "contrato" (o que pode ser chamado), mas o objeto real define o "comportamento" (como é executado).

**O que você melhoraria no seu projeto se pudesse refazer?**
Algumas coisas que eu deixaria diferente:
- Criaria uma classe `Motorista` (atualmente o veículo não tem dono, e isso é meio estranho num app de mobilidade).
- Usaria `List<Viagem>` no `Passageiro` pra guardar o histórico de viagens (associação um-pra-muitos), em vez de só ter a viagem isolada.
- Substituiria os `System.out.println` de erro por exceções (`throw new IllegalArgumentException(...)`), porque é o jeito mais profissional de sinalizar problema.
- Escreveria testes unitários com JUnit pra cada classe, em vez de testar tudo só pelo `Main`.

Mas pra um primeiro projeto sério de POO, achei que o resultado ficou bem coerente e pratiquei mesmo cada conceito.
