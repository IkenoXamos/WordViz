package com.wordviz.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.wordviz.test.controller.ChapterControllerTest;
import com.wordviz.test.controller.StoryControllerTest;
import com.wordviz.test.controller.TagControllerTest;
import com.wordviz.test.controller.UserControllerTest;
import com.wordviz.test.models.ChapterTest;
import com.wordviz.test.models.StoryTest;
import com.wordviz.test.models.TagTest;
import com.wordviz.test.models.UserTest;
import com.wordviz.test.services.ChapterServiceTest;
import com.wordviz.test.services.StoryServiceTest;
import com.wordviz.test.services.TagServiceTest;
import com.wordviz.test.services.UserServiceTest;

@RunWith(Suite.class)
@SuiteClasses({ WordVizApplicationTests.class,
		ChapterControllerTest.class,
		StoryControllerTest.class,
		TagControllerTest.class,
		UserControllerTest.class,
		ChapterTest.class,
		StoryTest.class,
		TagTest.class,
		UserTest.class,
		ChapterServiceTest.class,
		StoryServiceTest.class,
		TagServiceTest.class,
		UserServiceTest.class
})
public class AllTests {

}
