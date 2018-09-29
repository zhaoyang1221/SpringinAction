package knights;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
* BraveKnight Tester. 
* 
* @author <Authors name> 
* @version 1.0
*/ 
public class BraveKnightTest { 

@Before
public void before() {
} 

@After
public void after() {
} 

/** 
* 
* Method: embarkOnQuest() 
* 
*/ 
@Test
public void testEmbarkOnQuest() {
    Quest mockQuest = mock(Quest.class);
    BraveKnight knight = new BraveKnight(mockQuest);
    knight.embarkOnQuest();
    verify(mockQuest, times(1)).embark();
} 


} 
