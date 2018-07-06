package knights;

/**
 * Created with IntelliJ IDEA.
 * User: zhaoyang
 * Date: 2018/7/6/0006
 * Description:
 */
public class BraveKnight implements Knight{
    private Quest quest;

    public BraveKnight(Quest quest) {
        this.quest = quest;
    }

    public void embarkOnQuest() {
        quest.embark();
    }
}