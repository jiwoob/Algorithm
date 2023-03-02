import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();

		str = str.replace("c=", "!");
		str = str.replace("c-", "!");
		str = str.replace("dz=", "!");
		str = str.replace("d-", "!");
		str = str.replace("lj", "!");
		str = str.replace("nj", "!");
		str = str.replace("s=", "!");
		str = str.replace("z=", "!");

		bw.write(str.length() + "");

		bw.close();
	}
}