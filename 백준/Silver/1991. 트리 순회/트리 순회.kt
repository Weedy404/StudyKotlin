import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack

data class childNodes(var left: Char, var right: Char)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val nodeArray = Array<childNodes?>(26) { null }
    val result = StringBuilder()
    
    repeat(n) {
        val (parent, left, right) = br.readLine().split(" ").map{ it[0] }
        nodeArray[parent-'A'] = childNodes(left, right)
    }

    //전위 순회
    fun preOrder() {
        val st = Stack<Char>()
        st.add('A')
        
        while(!st.isEmpty()) {
            val pop = st.pop()
            val right = nodeArray[pop-'A']?.right
            val left = nodeArray[pop-'A']?.left
            result.append(pop.toString())
            listOf(right, left).filter { it != '.' }.forEach { st.add(it) }
        }
        result.append("\n")
    }

    //중위 순회
    fun inOrder() {
        val st = Stack<Char>()
        st.add('A')

        while(!st.isEmpty()) {

            //우선 왼쪽 자식 노드 다 넣음
            while(!st.isEmpty()) {
                val peek = st.peek()
                if(nodeArray[peek-'A']?.left != '.') {
                    st.add(nodeArray[peek-'A']?.left)
                } else {
                    break
                }
            }

            //하나씩 꺼내며 오른쪽 노드가 있는지 검사
            while(!st.isEmpty()) {
                val pop = st.pop()
                result.append(pop)
                if(nodeArray[pop-'A']?.right != '.') {
                    st.add(nodeArray[pop-'A']?.right)
                    break;
                }
            }
        }
        result.append("\n")
    }

    //후위 순회
    fun postOrder() {
        val st = Stack<Char>()
        val reverseStack = Stack<Char>()
        st.add('A')
        
        while(!st.isEmpty()) {
            val pop = st.pop()
            val right = nodeArray[pop-'A']?.right
            val left = nodeArray[pop-'A']?.left
            reverseStack.add(pop)
            listOf(left,right).filter { it != '.' }.forEach { st.add(it) }
        }
        while(!reverseStack.isEmpty()){
            val pop = reverseStack.pop()
            result.append(pop)
        }
        result.append("\n")
    }

    preOrder()
    inOrder()
    postOrder()
    print(result.toString())
}