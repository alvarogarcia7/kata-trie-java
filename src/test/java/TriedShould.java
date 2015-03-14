import com.example.datastructures.trie.MyTrie;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by alvaro on 14/03/15.
 */
public class TriedShould {

	@Test
	public void be_empty_by_default () {
		assertThat(new MyTrie().isEmpty(), is(true));
	}
}
