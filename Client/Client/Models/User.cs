using System.ComponentModel.DataAnnotations;
using System.Diagnostics.CodeAnalysis;
using System.Runtime.Serialization;
using System.Text.Json.Serialization;

namespace Client.Models
{
    public class User
    {
        [JsonPropertyName("username")]
        [Required, MaxLength(30)]
        [NotNull]
        public string UserName { get; set; }

        [Required, MaxLength(30), MinLength(8, ErrorMessage = "The password should be longer then 8")]
        [NotNull]
        [JsonPropertyName("password")]
        public string Password { get; set; }

        [JsonPropertyName("_id")] public ObjectIDGenerator UserId { get; set; }

        [JsonPropertyName("securityLevel")] public int SecurityLevel { get; set; }

        [Required, MaxLength(30)]
        [NotNull]
        [JsonPropertyName("firstName")]
        public string FirstName { get; set; }

        [Required, MaxLength(30)]
        [NotNull]
        [JsonPropertyName("lastName")]
        public string LastName { get; set; }

        [Required, MaxLength(30)]
        [NotNull]
        [JsonPropertyName("emali")]
        public string Email { get; set; }

        [MinLength(1, ErrorMessage = "Select a type.")]
        [JsonPropertyName("userType")]
        public string UserType { get; set; }
    }
}