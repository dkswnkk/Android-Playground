import java.io.DataInput
import java.io.DataInputStream
import java.io.DataOutput
import java.io.DataOutputStream
import java.net.ServerSocket

fun main(){
    // 서버 역할을 하기 위한 객체를 생성한다.
    val server = ServerSocket(22222)
    println("사용자 접속 대기")
    val socket = server.accept()

    println(socket)
    val outputStream = socket.getOutputStream()
    val dos = DataOutputStream(outputStream)

    dos.writeInt(100)
    dos.writeDouble(111.11)
    dos.writeBoolean(false)
    dos.writeUTF("문자열입니다.")


    // 클라이언트가 보낸 데이터를 수신한다.
    val inputStream = socket.getInputStream()
    val dis = DataInputStream(inputStream)

    val a1 = dis.readInt()
    val a2 = dis.readUTF()

    println(a1)
    println(a2)
    // 서버를 종료한다.
    socket.close()
}
