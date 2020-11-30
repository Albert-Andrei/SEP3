#pragma checksum "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\Shared\LogInComponent.razor" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "f90673f1db6b42ed6cafb48f1450e06349b614b0"
// <auto-generated/>
#pragma warning disable 1591
#pragma warning disable 0414
#pragma warning disable 0649
#pragma warning disable 0169

namespace AndriuhaAssignment.Shared
{
    #line hidden
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Threading.Tasks;
    using Microsoft.AspNetCore.Components;
#nullable restore
#line 1 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\_Imports.razor"
using System.Net.Http;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\_Imports.razor"
using Microsoft.AspNetCore.Authorization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 3 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\_Imports.razor"
using Microsoft.AspNetCore.Components.Authorization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 4 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\_Imports.razor"
using Microsoft.AspNetCore.Components.Forms;

#line default
#line hidden
#nullable disable
#nullable restore
#line 5 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\_Imports.razor"
using Microsoft.AspNetCore.Components.Routing;

#line default
#line hidden
#nullable disable
#nullable restore
#line 6 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\_Imports.razor"
using Microsoft.AspNetCore.Components.Web;

#line default
#line hidden
#nullable disable
#nullable restore
#line 7 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\_Imports.razor"
using Microsoft.JSInterop;

#line default
#line hidden
#nullable disable
#nullable restore
#line 8 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\_Imports.razor"
using AndriuhaAssignment;

#line default
#line hidden
#nullable disable
#nullable restore
#line 9 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\_Imports.razor"
using AndriuhaAssignment.Shared;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\Shared\LogInComponent.razor"
using AndriuhaAssignment.Authentication;

#line default
#line hidden
#nullable disable
    [Microsoft.AspNetCore.Components.RouteAttribute("/log-in")]
    public partial class LogInComponent : Microsoft.AspNetCore.Components.ComponentBase
    {
        #pragma warning disable 1998
        protected override void BuildRenderTree(Microsoft.AspNetCore.Components.Rendering.RenderTreeBuilder __builder)
        {
        }
        #pragma warning restore 1998
#nullable restore
#line 67 "C:\Users\User\RiderProjects\Brazor\AndrihaHelp\Andriuha\AndriuhaAssignment\Shared\LogInComponent.razor"
       
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
            NavigationManager.NavigateTo("/");
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