package ru.naumen.sd40.log.parser;

import org.junit.Assert;
import org.junit.Test;

public class ActionDoneParserTest {

    @Test
    public void mustParseAddAction() {
        //given
        ActionDoneParser parser = new ActionDoneParser();

        //when
        parser.parseData("Done(10): AddObjectAction");

        //then
        Assert.assertEquals(1, parser.getAddObjectActions());
    }

    @Test
    public void mustParseFormActions() {
        //given
        ActionDoneParser parser = new ActionDoneParser();

        //when
        parser.parseData("Done(10): GetFormAction");
        parser.parseData("Done(1): GetAddFormContextDataAction");

        //then
        Assert.assertEquals(2, parser.getFormActions());
    }

    @Test
    public void mustParseEditObject() {
        //given
        ActionDoneParser parser=  new ActionDoneParser();

        //when
        parser.parseData("Done(10): EditObjectAction");

        //then
        Assert.assertEquals(1, parser.getEditObjectsActions());
    }

    @Test
    public void mustParseSearchObject(){
        //given
        ActionDoneParser parser = new ActionDoneParser();

        //when
        parser.parseData("Done(10): GetPossibleAgreementsChildsSearchAction");
        parser.parseData("Done(10): TreeSearchAction");
        parser.parseData("Done(10): GetSearchResultAction");
        parser.parseData("Done(10): GetSimpleSearchResultsAction");
        parser.parseData("Done(10): SimpleSearchAction");
        parser.parseData("Done(10): ExtendedSearchByStringAction");
        parser.parseData("Done(10): ExtendedSearchByFilterAction");

        //then
        Assert.assertEquals(7, parser.getSearchActions());
    }

    @Test
    public void mustParseGetList(){
        //given:
        ActionDoneParser parser=  new ActionDoneParser();

        //when:
        parser.parseData("Done(10): GetDtObjectListAction");
        parser.parseData("Done(10): GetPossibleCaseListValueAction");
        parser.parseData("Done(10): GetPossibleAgreementsTreeListActions");
        parser.parseData("Done(10): GetCountForObjectListAction");
        parser.parseData("Done(10): GetDataForObjectListAction");
        parser.parseData("Done(10): GetPossibleAgreementsListActions");
        parser.parseData("Done(10): GetDtObjectForRelObjListAction");

        //then:
        Assert.assertEquals(7, parser.getListActions());
    }

    @Test
    public void mustParseComment(){
        //given:
        ActionDoneParser parser=  new ActionDoneParser();

        //when:
        parser.parseData("Done(10): EditCommentAction");
        parser.parseData("Done(10): ChangeResponsibleWithAddCommentAction");
        parser.parseData("Done(10): ShowMoreCommentAttrsAction");
        parser.parseData("Done(10): CheckObjectsExceedsCommentsAmountAction");
        parser.parseData("Done(10): GetAddCommentPermissionAction");
        parser.parseData("Done(10): GetCommentDtObjectTemplateAction");

        //then:
        Assert.assertEquals(6, parser.getCommentActions());
    }

    @Test
    public void mustParseDtObject(){
        //given:
        ActionDoneParser parser=  new ActionDoneParser();

        //when:
        parser.parseData("Done(10): GetVisibleDtObjectAction");
        parser.parseData("Done(10): GetDtObjectsAction");
        parser.parseData("Done(10): GetDtObjectTreeSelectionStateAction");
        parser.parseData("Done(10): AbstractGetDtObjectTemplateAction");
        parser.parseData("Done(10): GetDtObjectTemplateAction");

        //then:
        Assert.assertEquals(5, parser.getDtObjectActions());
    }

}
