import com.example.datastructures.trie.LevelCounter;
import com.example.datastructures.trie.MyTrie;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by alvaro on 14/03/15.
 */
public class TrieShould {

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
	public void not_be_empty_after_adding_a_word () {

		myTrie = myTrie.add("a");

		assertThat(myTrie.isEmpty(), is(false));
	}

	@Test
	public void not_contain_a_non_existing_word () {
		assertThat(myTrie.contains("a"), is(false));
	}

	@Test
	public void contain_an_existing_word () {
		myTrie = myTrie.add("a");

		assertThat(myTrie.contains("a"), is(true));
	}

	@Test
	public void add_a_word_with_a_common_suffix_to_an_existing_word () {
		myTrie = myTrie.add("a");

		myTrie = myTrie.add("ab");

		assertThat(myTrie.contains("a"), is(true));
		assertThat(myTrie.contains("ab"), is(true));
	}

	@Test
	public void count_how_many_steps_to_find_a_word () {
		final LevelCounter levelCounter = new LevelCounter();
		myTrie.injectLevelCounter(levelCounter);
		myTrie = myTrie.add("a");

		myTrie.contains("a");

		assertThat(levelCounter.callNumber(), is(2));
	}

	@Test
	public void traverse_only_nodes_matching_the_prefix () {
		final LevelCounter levelCounter = new LevelCounter();
		myTrie.injectLevelCounter(levelCounter);
		myTrie = myTrie.add("a");
		myTrie = myTrie.add("b");
		myTrie = myTrie.add("c");
		myTrie = myTrie.add("d");
		myTrie = myTrie.add("ab");

		assertThat(myTrie.contains("ab"), is(true));

		assertThat(levelCounter.callNumber(), is(2));
	}

	@Test
	public void not_contain_intermediate_words () {
		myTrie = myTrie.add("cd");

		assertThat(myTrie.contains("c"), is(false));
	}

}
