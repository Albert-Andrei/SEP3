#pragma checksum "D:\VIA\Semester 3\Semester project\SEP3\Client\Client\Pages\HomeComponent.razor" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "709797bfde2caa3b5703ecfdaa675e576895cf2b"
// <auto-generated/>
#pragma warning disable 1591
namespace Client.Pages
{
    #line hidden
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Threading.Tasks;
    using Microsoft.AspNetCore.Components;
#nullable restore
#line 1 "D:\VIA\Semester 3\Semester project\SEP3\Client\Client\_Imports.razor"
using System.Net.Http;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "D:\VIA\Semester 3\Semester project\SEP3\Client\Client\_Imports.razor"
using Microsoft.AspNetCore.Authorization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 3 "D:\VIA\Semester 3\Semester project\SEP3\Client\Client\_Imports.razor"
using Microsoft.AspNetCore.Components.Authorization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 4 "D:\VIA\Semester 3\Semester project\SEP3\Client\Client\_Imports.razor"
using Microsoft.AspNetCore.Components.Forms;

#line default
#line hidden
#nullable disable
#nullable restore
#line 5 "D:\VIA\Semester 3\Semester project\SEP3\Client\Client\_Imports.razor"
using Microsoft.AspNetCore.Components.Routing;

#line default
#line hidden
#nullable disable
#nullable restore
#line 6 "D:\VIA\Semester 3\Semester project\SEP3\Client\Client\_Imports.razor"
using Microsoft.AspNetCore.Components.Web;

#line default
#line hidden
#nullable disable
#nullable restore
#line 7 "D:\VIA\Semester 3\Semester project\SEP3\Client\Client\_Imports.razor"
using Microsoft.JSInterop;

#line default
#line hidden
#nullable disable
#nullable restore
#line 8 "D:\VIA\Semester 3\Semester project\SEP3\Client\Client\_Imports.razor"
using Client;

#line default
#line hidden
#nullable disable
#nullable restore
#line 9 "D:\VIA\Semester 3\Semester project\SEP3\Client\Client\_Imports.razor"
using Client.Shared;

#line default
#line hidden
#nullable disable
    [Microsoft.AspNetCore.Components.RouteAttribute("/home")]
    public partial class HomeComponent : Microsoft.AspNetCore.Components.ComponentBase
    {
        #pragma warning disable 1998
        protected override void BuildRenderTree(Microsoft.AspNetCore.Components.Rendering.RenderTreeBuilder __builder)
        {
            __builder.AddMarkupContent(0, "<link href=\"css/HomeComponent.razor.css\" media=\"screen\" rel=\"stylesheet\">\r\n\r\n");
            __builder.AddMarkupContent(1, "<div class=\"photo1\">\r\n    <img src=\"work.png\" width=\"350\" height=\"500\">\r\n</div>\r\n\r\n");
            __builder.OpenElement(2, "div");
            __builder.AddAttribute(3, "class", "background");
            __builder.AddMarkupContent(4, "\r\n    ");
            __builder.AddMarkupContent(5, @"<div class=""headerHome"">
        <h1 class=""headerFirst""> Platform Made for Employee and Employeer</h1>
        <h1 class=""headerSecond""> for job search and application</h1>
        <h2 class=""headerThird"">Create account its totaly free</h2>
    </div>
     
    ");
            __builder.OpenElement(6, "button");
            __builder.AddAttribute(7, "onclick", Microsoft.AspNetCore.Components.EventCallback.Factory.Create<Microsoft.AspNetCore.Components.Web.MouseEventArgs>(this, 
#nullable restore
#line 17 "D:\VIA\Semester 3\Semester project\SEP3\Client\Client\Pages\HomeComponent.razor"
                      NavigateToSignup

#line default
#line hidden
#nullable disable
            ));
            __builder.AddAttribute(8, "class", "buttonSign");
            __builder.AddContent(9, "sign up!");
            __builder.CloseElement();
            __builder.AddMarkupContent(10, "\r\n    ");
            __builder.AddMarkupContent(11, "<div class=\"headerHome\">\r\n        <h2 class=\"headerThird\">If you already user</h2>\r\n    </div>\r\n    ");
            __builder.OpenElement(12, "button");
            __builder.AddAttribute(13, "onclick", Microsoft.AspNetCore.Components.EventCallback.Factory.Create<Microsoft.AspNetCore.Components.Web.MouseEventArgs>(this, 
#nullable restore
#line 21 "D:\VIA\Semester 3\Semester project\SEP3\Client\Client\Pages\HomeComponent.razor"
                      NavigateToLogin

#line default
#line hidden
#nullable disable
            ));
            __builder.AddAttribute(14, "class", "buttonSign");
            __builder.AddContent(15, "log in");
            __builder.CloseElement();
            __builder.AddMarkupContent(16, "\r\n");
            __builder.CloseElement();
            __builder.AddMarkupContent(17, "\r\n");
            __builder.AddMarkupContent(18, "<div class=\"navbars\">\r\n    <a href=\"AboutComponent\">About this project</a>\r\n    <a href=\"ContactComponent\">Contact Us</a>\r\n  \r\n</div>");
        }
        #pragma warning restore 1998
#nullable restore
#line 30 "D:\VIA\Semester 3\Semester project\SEP3\Client\Client\Pages\HomeComponent.razor"
       
    //   wwwroot/worker.jpg
    private  void  NavigateToSignup()
    {
        NavigationManager.NavigateTo("/sign-up",true);
    }
    private  void  NavigateToLogin()
    {
        NavigationManager.NavigateTo("/log-in",true);
    }
    

#line default
#line hidden
#nullable disable
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private NavigationManager NavigationManager { get; set; }
    }
}
#pragma warning restore 1591
