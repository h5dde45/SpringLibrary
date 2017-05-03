package ru.javabegin.training.springlibrary.objects;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import ru.javabegin.training.springlibrary.enums.SearchType;

import javax.faces.context.FacesContext;
import java.util.HashMap;
import java.util.Map;

@Component
public class Utils {

    private Map<String, SearchType> searchTypeList =new HashMap<String, SearchType>();
    private SearchType selectSearchType=SearchType.TITLE;

    private Character[] letters = new Character[]{'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я'};

    public Character[] getLetters() {
        return letters;
    }

    @Autowired
    private MessageSource msg;

    public Map<String, SearchType> getSearchTypeList() {
        searchTypeList.clear();
        searchTypeList.put(msg.getMessage("author_name",null, FacesContext.getCurrentInstance().
        getViewRoot().getLocale()),SearchType.AUTHOR);
        searchTypeList.put(msg.getMessage("book_name",null, FacesContext.getCurrentInstance().
        getViewRoot().getLocale()),SearchType.TITLE);
        return searchTypeList;
    }

    public void setSearchTypeList(Map<String, SearchType> searchTypeList) {
        this.searchTypeList = searchTypeList;
    }

    public SearchType getSelectSearchType() {
        return selectSearchType;
    }

}
