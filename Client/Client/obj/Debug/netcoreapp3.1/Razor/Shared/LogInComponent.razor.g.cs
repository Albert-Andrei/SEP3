#pragma checksum "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Shared\LogInComponent.razor" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "660005a661e2672139f87c2e8f7602e957e3a136"
// <auto-generated/>
#pragma warning disable 1591
namespace Client.Shared
{
    #line hidden
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Threading.Tasks;
    using Microsoft.AspNetCore.Components;
#nullable restore
#line 1 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\_Imports.razor"
using System.Net.Http;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\_Imports.razor"
using Microsoft.AspNetCore.Authorization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 3 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\_Imports.razor"
using Microsoft.AspNetCore.Components.Authorization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 4 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\_Imports.razor"
using Microsoft.AspNetCore.Components.Forms;

#line default
#line hidden
#nullable disable
#nullable restore
#line 5 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\_Imports.razor"
using Microsoft.AspNetCore.Components.Routing;

#line default
#line hidden
#nullable disable
#nullable restore
#line 6 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\_Imports.razor"
using Microsoft.AspNetCore.Components.Web;

#line default
#line hidden
#nullable disable
#nullable restore
#line 7 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\_Imports.razor"
using Microsoft.JSInterop;

#line default
#line hidden
#nullable disable
#nullable restore
#line 8 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\_Imports.razor"
using Client;

#line default
#line hidden
#nullable disable
#nullable restore
#line 9 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\_Imports.razor"
using Client.Shared;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Shared\LogInComponent.razor"
using Client.Authentication;

#line default
#line hidden
#nullable disable
    [Microsoft.AspNetCore.Components.RouteAttribute("/log-in")]
    public partial class LogInComponent : Microsoft.AspNetCore.Components.ComponentBase
    {
        #pragma warning disable 1998
        protected override void BuildRenderTree(Microsoft.AspNetCore.Components.Rendering.RenderTreeBuilder __builder)
        {
            __builder.OpenComponent<Microsoft.AspNetCore.Components.Authorization.AuthorizeView>(0);
            __builder.AddAttribute(1, "NotAuthorized", (Microsoft.AspNetCore.Components.RenderFragment<Microsoft.AspNetCore.Components.Authorization.AuthenticationState>)((context) => (__builder2) => {
#nullable restore
#line 9 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Shared\LogInComponent.razor"
         if (loading == true)
        {

#line default
#line hidden
#nullable disable
                __builder2.AddMarkupContent(2, "<div class=\"bg-image\"></div>");
                __builder2.OpenElement(3, "div");
                __builder2.AddAttribute(4, "class", "loading");
                __builder2.OpenElement(5, "div");
                __builder2.AddAttribute(6, "class", "bg-text");
                __builder2.OpenComponent<Client.Shared.Loading>(7);
                __builder2.CloseComponent();
                __builder2.AddMarkupContent(8, "\r\n                    ");
                __builder2.AddMarkupContent(9, "<h4> We are processing your data, please wait.</h4>\r\n                    ");
                __builder2.AddMarkupContent(10, "<h3><b>We care about your safety</b></h3>");
                __builder2.CloseElement();
                __builder2.CloseElement();
#nullable restore
#line 22 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Shared\LogInComponent.razor"
        }

#line default
#line hidden
#nullable disable
                __builder2.OpenElement(11, "div");
                __builder2.AddAttribute(12, "class", "container");
                __builder2.OpenElement(13, "div");
                __builder2.AddAttribute(14, "class", "row");
                __builder2.OpenElement(15, "div");
                __builder2.AddAttribute(16, "class", "col-md-4 offset-md-4 offset-sm-4");
                __builder2.OpenElement(17, "div");
                __builder2.AddAttribute(18, "class", "logIn");
                __builder2.AddMarkupContent(19, "<img style=\"width: 200px; margin-top: 10px;\r\n                                                      margin-bottom: 10px; \" src=\"imagne.png\">\r\n\r\n                        ");
                __builder2.OpenElement(20, "form");
                __builder2.AddAttribute(21, "class", "username");
                __builder2.AddAttribute(22, "style", "width: 100%");
                __builder2.OpenElement(23, "div");
                __builder2.AddAttribute(24, "class", "form-group");
                __builder2.OpenElement(25, "label");
                __builder2.AddAttribute(26, "class", "form-group-label1");
                __builder2.AddAttribute(27, "style", "display:" + (
#nullable restore
#line 34 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Shared\LogInComponent.razor"
                                                                                 disply1

#line default
#line hidden
#nullable disable
                ) + ";");
                __builder2.AddContent(28, "Username");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(29, "\r\n                                ");
                __builder2.OpenElement(30, "input");
                __builder2.AddAttribute(31, "type", "text");
                __builder2.AddAttribute(32, "placeholder", "Enter Username");
                __builder2.AddAttribute(33, "name", "uname");
                __builder2.AddAttribute(34, "required", true);
                __builder2.AddAttribute(35, "class", "form-control input-lg");
                __builder2.AddAttribute(36, "oninput", Microsoft.AspNetCore.Components.EventCallback.Factory.Create<Microsoft.AspNetCore.Components.ChangeEventArgs>(this, 
#nullable restore
#line 36 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Shared\LogInComponent.razor"
                                                                                 (arg) => change(arg)

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(37, "value", Microsoft.AspNetCore.Components.BindConverter.FormatValue(
#nullable restore
#line 35 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Shared\LogInComponent.razor"
                                                                                                                   username

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(38, "onchange", Microsoft.AspNetCore.Components.EventCallback.Factory.CreateBinder(this, __value => username = __value, username));
                __builder2.SetUpdatesAttributeName("value");
                __builder2.CloseElement();
                __builder2.CloseElement();
                __builder2.CloseElement();
                __builder2.AddMarkupContent(39, "\r\n                        ");
                __builder2.OpenElement(40, "div");
                __builder2.AddAttribute(41, "style", "color:red");
                __builder2.AddContent(42, 
#nullable restore
#line 39 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Shared\LogInComponent.razor"
                                                errorMessageUname

#line default
#line hidden
#nullable disable
                );
                __builder2.CloseElement();
                __builder2.AddMarkupContent(43, "\r\n\r\n                        ");
                __builder2.OpenElement(44, "form");
                __builder2.AddAttribute(45, "class", "password");
                __builder2.AddAttribute(46, "style", "width: 100%");
                __builder2.OpenElement(47, "div");
                __builder2.AddAttribute(48, "class", "form-group");
                __builder2.OpenElement(49, "label");
                __builder2.AddAttribute(50, "class", "form-group-label2");
                __builder2.AddAttribute(51, "style", "display:" + (
#nullable restore
#line 43 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Shared\LogInComponent.razor"
                                                                                 disply2

#line default
#line hidden
#nullable disable
                ) + ";");
                __builder2.AddContent(52, " Passord ");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(53, "\r\n                                ");
                __builder2.OpenElement(54, "input");
                __builder2.AddAttribute(55, "type", "password");
                __builder2.AddAttribute(56, "placeholder", "Enter Password");
                __builder2.AddAttribute(57, "name", "psw");
                __builder2.AddAttribute(58, "required", true);
                __builder2.AddAttribute(59, "class", "form-control input-lg");
                __builder2.AddAttribute(60, "oninput", Microsoft.AspNetCore.Components.EventCallback.Factory.Create<Microsoft.AspNetCore.Components.ChangeEventArgs>(this, 
#nullable restore
#line 45 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Shared\LogInComponent.razor"
                                                                               (arg) => change2(arg)

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(61, "value", Microsoft.AspNetCore.Components.BindConverter.FormatValue(
#nullable restore
#line 44 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Shared\LogInComponent.razor"
                                                                                                                     password

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(62, "onchange", Microsoft.AspNetCore.Components.EventCallback.Factory.CreateBinder(this, __value => password = __value, password));
                __builder2.SetUpdatesAttributeName("value");
                __builder2.CloseElement();
                __builder2.CloseElement();
                __builder2.CloseElement();
                __builder2.AddMarkupContent(63, "\r\n                        ");
                __builder2.OpenElement(64, "div");
                __builder2.AddAttribute(65, "style", "color:red");
                __builder2.AddContent(66, 
#nullable restore
#line 48 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Shared\LogInComponent.razor"
                                                errorMessagePsw

#line default
#line hidden
#nullable disable
                );
                __builder2.CloseElement();
                __builder2.AddMarkupContent(67, "\r\n\r\n                        ");
                __builder2.OpenElement(68, "div");
                __builder2.AddAttribute(69, "style", "color:red");
                __builder2.AddContent(70, 
#nullable restore
#line 50 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Shared\LogInComponent.razor"
                                                errorMessage

#line default
#line hidden
#nullable disable
                );
                __builder2.CloseElement();
                __builder2.AddMarkupContent(71, "\r\n                        ");
                __builder2.OpenElement(72, "button");
                __builder2.AddAttribute(73, "type", "button");
                __builder2.AddAttribute(74, "class", "logInBtn");
                __builder2.AddAttribute(75, "onclick", Microsoft.AspNetCore.Components.EventCallback.Factory.Create<Microsoft.AspNetCore.Components.Web.MouseEventArgs>(this, 
#nullable restore
#line 51 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Shared\LogInComponent.razor"
                                                                         PerformLogin

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(76, "style", "display:" + " " + (
#nullable restore
#line 51 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Shared\LogInComponent.razor"
                                                                                                        displyBtn

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddContent(77, "Log In");
                __builder2.CloseElement();
                __builder2.AddMarkupContent(78, "\r\n                        ");
                __builder2.OpenElement(79, "div");
                __builder2.AddAttribute(80, "class", "SignUpPar");
                __builder2.OpenElement(81, "p");
                __builder2.AddAttribute(82, "style", "display:" + " " + (
#nullable restore
#line 53 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Shared\LogInComponent.razor"
                                                displyBtn

#line default
#line hidden
#nullable disable
                ) + ";" + " margin:" + " 0;" + " padding:" + " 0;");
                __builder2.AddAttribute(83, "onclick", Microsoft.AspNetCore.Components.EventCallback.Factory.Create<Microsoft.AspNetCore.Components.Web.MouseEventArgs>(this, 
#nullable restore
#line 53 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Shared\LogInComponent.razor"
                                                                                             Navigate

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddContent(84, "Sign Up");
                __builder2.CloseElement();
                __builder2.CloseElement();
                __builder2.CloseElement();
                __builder2.CloseElement();
                __builder2.CloseElement();
                __builder2.CloseElement();
            }
            ));
            __builder.AddAttribute(85, "Authorized", (Microsoft.AspNetCore.Components.RenderFragment<Microsoft.AspNetCore.Components.Authorization.AuthenticationState>)((context) => (__builder2) => {
                __builder2.OpenElement(86, "div");
                __builder2.AddAttribute(87, "class", "logoutview");
                __builder2.AddMarkupContent(88, "<h1 class=\"text-no\" style=\"text-align: center\">It was a pleasure to work with you, see you later.</h1>\r\n            ");
                __builder2.OpenElement(89, "div");
                __builder2.OpenElement(90, "button");
                __builder2.AddAttribute(91, "onclick", Microsoft.AspNetCore.Components.EventCallback.Factory.Create<Microsoft.AspNetCore.Components.Web.MouseEventArgs>(this, 
#nullable restore
#line 66 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Shared\LogInComponent.razor"
                                  PerformLogout

#line default
#line hidden
#nullable disable
                ));
                __builder2.AddAttribute(92, "class", "logout");
                __builder2.AddAttribute(93, "type", "button");
                __builder2.AddContent(94, " Log out");
                __builder2.CloseElement();
                __builder2.CloseElement();
                __builder2.CloseElement();
            }
            ));
            __builder.CloseComponent();
        }
        #pragma warning restore 1998
#nullable restore
#line 72 "C:\Users\mirek\Documents\GitHub\SEP3\Client\Client\Shared\LogInComponent.razor"
       
    private string username;
    private string password;
    private string errorMessage;
    private string errorMessageUname;
    private string errorMessagePsw;
    private bool loading = false;
    private string displyBtn;

    public async Task PerformLogin()
    {
        errorMessageUname = "";
        errorMessagePsw = "";
        try
        {
            loading = true;
            await ((CustomAuthenticationStateProvider) AuthenticationStateProvider).ValidateLogin(username, password);
            if (((CustomAuthenticationStateProvider) AuthenticationStateProvider).ValidatedUsernameType().Equals("Employer"))
            {
                NavigationManager.NavigateTo("/shift-list");
            }
            else
            {
                NavigationManager.NavigateTo("/empl-shifts");
            }
            loading = false;
            username = "";
            password = "";
            displyBtn = "block";
        }
        catch (Exception e)
        {
            if (e.Message.Equals("Enter username"))
            {
                loading = false;
                errorMessageUname = e.Message;
                errorMessagePsw = "";
                displyBtn = "none";
            }
            else if (e.Message.Equals("Enter password"))
            {
                loading = false;
                errorMessageUname = "";
                errorMessagePsw = e.Message;
                displyBtn = "none";
            }
            else
            {
                loading = false;
                errorMessage = e.Message;
                displyBtn = "none";
            }
        }
    }

    public async Task PerformLogout()
    {
        errorMessageUname = "";
        errorMessagePsw = "";
        errorMessage = "";
        try
        {
            ((CustomAuthenticationStateProvider) AuthenticationStateProvider).Logout();
            NavigationManager.NavigateTo("/");
            username = "";
            password = "";
        }
        catch (Exception e)
        {
        }
    }

    private string disply1 = "none";
    private string disply2 = "none";

    private void change(ChangeEventArgs changeEventArgs)
    {
        if (!string.IsNullOrEmpty(changeEventArgs.Value.ToString()))
        {
            disply1 = "block";
            errorMessageUname = "";
            errorMessage = "";
            displyBtn = "block";
        }
        else
        {
            disply1 = "none";
        }
    }

    private void change2(ChangeEventArgs changeEventArgs)
    {
        if (!string.IsNullOrEmpty(changeEventArgs.Value.ToString()))
        {
            disply2 = "block";
            errorMessagePsw = "";
            errorMessage = "";
            displyBtn = "block";
        }
        else
        {
            disply2 = "none";
        }
    }

    private void Navigate()
    {
        NavigationManager.NavigateTo("/sign-up");
    }


#line default
#line hidden
#nullable disable
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private NavigationManager NavigationManager { get; set; }
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private AuthenticationStateProvider AuthenticationStateProvider { get; set; }
    }
}
#pragma warning restore 1591
