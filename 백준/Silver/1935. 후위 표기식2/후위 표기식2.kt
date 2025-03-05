fun main(){
    val N = readLine()?.toInt() ?: 0
    val postfix = readLine()?.toCharArray()
    val stack = mutableListOf<Double>()
    val values = mutableListOf<Double>()

    repeat(N){
        values.add(readLine()?.toDouble() ?: 0.00)
    }

    if(postfix != null){
        for(i in 0 until postfix.size){
            if('A'<=postfix[i] && postfix[i] <= 'Z'){
                stack.add(values[postfix[i]-'A'])
            }else{
                val firstPop = stack.removeAt(stack.lastIndex)
                val secondPop = stack.removeAt(stack.lastIndex)

                when(postfix[i]){
                    '*' -> stack.add(secondPop*firstPop)
                    '/' -> stack.add(secondPop/firstPop)
                    '+' -> stack.add(secondPop+firstPop)
                    '-' -> stack.add(secondPop-firstPop)
                }
            }
        }
        print(String.format("%.2f", stack.removeAt(0)))
    }
}