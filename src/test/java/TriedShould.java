import com.example.datastructures.trie.MyTrie;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by alvaro on 14/03/15.
 */
public class TriedShould {

	private MyTrie myTrie;

	@Before
	public void setUp () throws Exception {
		myTrie = new MyTrie();
	}

	@Test
	public void be_empty_by_default () {
		assertThat(myTrie.isEmpty(), is(true));
	}

	@Test
	public void add_non_a_existing_word () {

		assertThat(myTrie.add("a").isEmpty(), is(false));
	}
}
