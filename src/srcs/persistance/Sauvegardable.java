package srcs.persistance;

import java.io.*;

public interface Sauvegardable {

	public void save(OutputStream out) throws IOException;
}
