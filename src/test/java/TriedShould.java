import com.example.datastructures.trie.MyTrie;
import org.junit.Test;

/**
 * Created by alvaro on 14/03/15.
 */
public class TriedShould {

	@Test
	public void be_empty_by_default () {

		org.hamcrest.MatcherAssert.assertThat(new MyTrie().isEmpty(), org.hamcrest.Matchers.is(true));

	}
}
