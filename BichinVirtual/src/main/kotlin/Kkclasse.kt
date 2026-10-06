import kotlin.system.exitProcess


var nome = ""
var fome = 0
var idade = 0
var felicidade = 50
var cansaco = 0

    fun main(){
        inicio()
}

fun status(){
    println("Idade: $idade\nNível de fome: $fome\nFelicidade: $felicidade\nCansaço: $cansaco")

    if (fome >= 50){
        println("O pet precisa ser alimentado, pois sua fome é significativa.")
    }
    if (felicidade <= 25 && cansaco <= 75){
        println("O pet está infeliz, vocês podem brincar.")
    }

    if (cansaco >= 50){
        println("O pet está cansado, precisa descansar.")
    }

    inicio()

}

fun inicio(){
    if(nome == ""){
        println("Bem vindo ao jogo do bichin virtual, dê um nome para seu pet: ")
        nome = readln()

        print("$nome é um belíssimo nome!")
    }

    println(""" Objetivo = Fazer $nome viver até os 50 anos.
                Vamos lá, o que deseja fazer?
                1 - Brincar com $nome
                2 - Alimentar $nome
                3 - Fazer $nome descansar
                4 - Verificar status de $nome
                5 - Sair
                
    
                """)

    var escolha = readln().toInt()

    when(escolha){
        1 -> brincar()
        2 -> alimentar()
        3 -> descansar()
        4 -> status()
    }
}

fun brincar() {
    cansaco += 10
    felicidade += 3
    idade ++
    fome += 3



    if (cansaco >= 50 && idade < 50){
        println("Vocês já brincaram bastante né? Acho que seu pet poderia descansar agora.")
    }

    if(cansaco >= 90){
        println("Seu pet está próximo ao nível máximo de exaustão. NÃO BRINQUE MAIS!")
    }

    if (cansaco >= 100){
        println("Seu pet morreu de cansaço...\n")
        idade = 0
        felicidade = 100
        cansaco = 0
        nome = ""

        println("Jogar novamente? (Y/N)")

        var escolha = readln().uppercase()

        if (escolha == "Y"){
            inicio()
        } else{
            exitProcess(0)
        }
    }

    if (idade >= 50){
        println("Essa foi a última vez que vocês brincaram... Parabéns, $nome sobreviveu os 50 anos.\n")
        nome = ""
        exitProcess(0)
    }

    println("Você brincou com $nome! Continuar brincando? (Y/N)")

    var resposta = readln().uppercase()

    if (resposta == "Y"){
        brincar()
    } else{
        println("Voltando para o menu.")
        inicio()
    }
}

fun alimentar(){
    if (fome >= 3) {

        fome -= 3
        println("$nome foi alimentado.")
    } else{
        println("$nome não está com fome.")
    }

    inicio()

}

fun descansar(){
    if(cansaco == 0){
        println("O pet já está descansado, tente fazer outra coisa.")
        inicio()
    }

    idade ++
    cansaco = 0

    if (idade == 50){
        println("Essa foi a última descansada de $nome, mas não se preocupe, foi porque sobreviveu " +
                "os 50 anos... Parabéns.")
        nome = ""
        exitProcess(0)
    }

    println("${nome} descansou.")

    inicio()

}





