<html>
<head>
    <meta name="layout" content="main"/>
    <title>Weather Information</title>
</head>
<body>

<div id="content" role="main">
    <section class="row colset-2-its">
        <g:if test="${weatherInfoData}">
            <h2>Weather Information for ${zipcode}
            (<g:link url="${weatherInfoData.locationUrl}" target="_blank">${weatherInfoData.locationName}</g:link>)</h2>
            <table><tbody>
                <g:each in="${weatherInfoData.infoItems}">
                    <tr><td>${it.getItemDescText()}</td><td>${it.getItemDataText()}</td></tr>
                </g:each>
            </tbody></table>
        </g:if>
        <g:else>
            <h2>Unable to fetch Weather Information for ${zipcode}</h2>
        </g:else>
        <br>
        <br>
        <g:form action="enterZipcode">
            Enter another Zipcode:
            <g:textField name="zipcodeText" />
            <g:submitButton name="Submit" />
        </g:form>
        <br>
    </section>
</div>

</body>
</html>