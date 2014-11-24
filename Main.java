import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		int nRows = Integer.parseInt(args[0]);

		String resultado = "";
		String training = "";
		String test = "";
		String newRow;
		String dniConLetra;

		int nLineasTest = 0;
		int nLineasTrain = 0;
		
		Random rng = new Random(); // Ideally just create one instance globally
		// Note: use LinkedHashSet to maintain insertion order
		Set<String> generated = new LinkedHashSet<String>();
		for (int i = 0; i < nRows; i++) {
			Integer next = rng.nextInt(99999999) + 1;
			// As we're adding to a set, this will automatically do a
			// containment check
			dniConLetra = String.format("%08d", next) + letraDNI(next);
			newRow = "";
			for (int j = 0; j < dniConLetra.length(); j++) {
				if (j != 0)
					newRow += "\t";
				newRow += dniConLetra.charAt(j);
			}
			if (i != nRows - 1)
				newRow += "\n";

			if (generated.add(newRow)) {
				if (i < Math.round(nRows * 30 / 100.0)) {
					test += newRow;
					nLineasTest++;
				} else {
					nLineasTrain++;
					training += newRow;
				}

				resultado += newRow;
			}
		}

		try {

			File fileTotal = new File("completo.pat");
			File fileTrain = new File("train.pat");
			File fileTest = new File("test.pat");

			// if file doesnt exists, then create it

			escribir(fileTotal, resultado, nRows);
			escribir(fileTrain, training, nLineasTrain);
			escribir(fileTest, test, nLineasTest);

			//System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void escribir(File file, String codigo, int rows) throws IOException {
		codigo = codigo.trim();
		codigo  = cabecera(rows)+codigo;
		
		//System.out.println(codigo);
		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(codigo);
		bw.close();
	}

	public static final String NIF_STRING_ASOCIATION = "TRWAGMYFPDXBNJZSQVHLCKE";

	/**
	 * Devuelve un NIF completo a partir de un DNI. Es decir, añade la letra del
	 * NIF
	 * 
	 * @param dni
	 *            dni al que se quiere añadir la letra del NIF
	 * @return NIF completo.
	 */
	public static String letraDNI(int dni) {
		return NIF_STRING_ASOCIATION.charAt(dni % 23) + "";
	}

	public static String cabecera(int nRow) {
		return "SNNS pattern definition file V1.0\n"
				+ "enerated at Mon Nov 30 11:53:37 1999\n\n" +
				"No. of patterns : " + nRow + "\n" + "No. of input units : 8\n"
				+ "No. of output units : 1\n\n";

	}
}
