package com.box.boxjavalibv2.requests.requestobjects;

import com.box.boxjavalibv2.dao.BoxFile;
import com.box.boxjavalibv2.dao.BoxFolder;
import com.box.boxjavalibv2.dao.BoxItem;
import com.box.boxjavalibv2.jsonentities.MapJSONStringEntity;
import com.box.boxjavalibv2.jsonparsing.IBoxJSONParser;

public class BoxItemCopyRequestObject extends BoxDefaultRequestObject {

    protected BoxItemCopyRequestObject(IBoxJSONParser parser) {
        super(parser);
    }

    public static BoxItemCopyRequestObject copyItemRequestObject(String parentId, IBoxJSONParser parser) {
        return (new BoxItemCopyRequestObject(parser)).setParent(parentId);
    }

    /**
     * Set parent folder of the file.
     * 
     * @param parentId
     *            id of parent
     * @return
     */
    private BoxItemCopyRequestObject setParent(String parentId) {
        MapJSONStringEntity entity = new MapJSONStringEntity();
        entity.put(BoxFolder.FIELD_ID, parentId);
        put(BoxItem.FIELD_PARENT, entity);
        return this;
    }

    /**
     * Set name of the file.
     * 
     * @param name
     *            name
     * @return
     */
    public BoxItemCopyRequestObject setName(String name) {
        put(BoxFile.FIELD_NAME, name);
        return this;
    }
}