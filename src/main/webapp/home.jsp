<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Expense Management</title>
</head>

<body>

    <h2>Home Expense Management</h2>

    <ul>
        <s:iterator value="menuList">
            <li>
                <a href="<s:property value='menuAction'/>">
                    <s:property value="menuName"/>
                </a>
            </li>
        </s:iterator>
    </ul>

</body>
</html>